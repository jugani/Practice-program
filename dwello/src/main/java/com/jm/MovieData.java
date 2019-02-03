package com.jm;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MovieData {

    static String   inputUrl="https://jsonmock.hackerrank.com/api/movies/search/?Title=";


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System. in);
        String substr = in.nextLine();
        MovieData movieData = new MovieData();
        StringBuilder sb = new StringBuilder();
        sb.append(inputUrl);
        sb.append(substr);
        String requestURL = sb.toString();
       movieData.getMovieTitles(requestURL);

    }

    static void getMovieTitles( String url) throws IOException {

        System.out.println("indide get Movie Title");
        System.out.println(httpGet(url));




    }


    static String httpGet(String url) throws IOException {

        URL urlobj = new URL(url);
        HttpURLConnection httpURLConnection = (HttpURLConnection)urlobj.openConnection();
         httpURLConnection.setRequestMethod("GET");
       return String.valueOf(httpURLConnection.getResponseCode());




 }
}
