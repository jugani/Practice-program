
package com.tw.challenge;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;

public class TwApi {

    final String userId = "HJDpqWdYM";
    final String contentType = "application/json";
    final String inputUrl = "https://http-hunt.thoughtworks-labs.net/challenge/input";
    final String outputUrl = "https://http-hunt.thoughtworks-labs.net/challenge/output";
    private OkHttpClient client;

    public static void main(String args[]) throws IOException {

        TwApi twApi = new TwApi();
        twApi.client = twApi.getUnsafeOkHttpClient();
        StageOne stageOne = new StageOne();
        StageTwo stageTwo= new StageTwo();
        StageThree stageThree= new StageThree();

        String input = twApi.get(twApi.inputUrl);

        System.out.println(input);

        System.out.println("**************Stage one***************");
        JSONObject countJson = stageOne.getCount(input);
        System.out.println("stage output"+countJson);
        System.out.println("\t\t\t");
        //String Output= twApi.post(twApi.outputUrl,countJson);

        System.out.println("**************Stage two***************");
        JSONArray activeProducts= stageTwo.getActiveProductCount(input);
        System.out.println("\t\t\t");
        JSONObject activeProductsCount= stageTwo.getActiveProductCount(activeProducts);
        System.out.println("second stage output"+activeProductsCount);
        System.out.println("\t\t\t");
        //String Output= twApi.post(twApi.outputUrl,activeProductsCount);

        System.out.println("**************Stage three***************");
        JSONObject category= new JSONObject();
        System.out.println("Active products "+activeProducts);
        System.out.println("\t\t\t");
        JSONObject CategoryCountJson= stageThree.categoriesActiveProduct(activeProducts,category);
        System.out.println("Stage three Output:"+CategoryCountJson);
        String output= twApi.post(twApi.outputUrl,CategoryCountJson);
        System.out.println(output);

    }


    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", contentType)
                .addHeader("userId", userId)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }


    public String post(String url, JSONObject jsonobject) throws IOException {
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonobject.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", contentType)
                .addHeader("userId", userId)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
    private OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }
                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder.build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}