package com.jm;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;

//import static com.jm.ValidateIPv4.isValidInet4Address;

public class ValidateIp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] ip_array = new String[n];
        String[] output_array = new String[n];
        for (int i = 0; i < n; i++) {
            ip_array[i] = br.readLine();
        }
        int j = 0;
        for (String ip : ip_array) {
            System.out.println(ip);
            output_array[j] = checkIP(ip);
            j++;
        }
        for (String opt : output_array
                ) {
            System.out.println(opt);


        }
    }

    public static String checkIP(String ip) throws UnknownHostException {
        try {
            if (Inet4Address.getByName(ip)
                    .getHostAddress().equals(ip)) {

                return "IPV4";
            } else if (Inet6Address.getByName(ip).getHostAddress().equals(ip)) {
                //not working for valid ipv6 :(
                return "IPV6";
            } else {

                return "Neither";
            }


        }catch (UnknownHostException EX)
        {
            return "Neigther";
        }
//        finally {
//            System.out.println("hello" + Inet6Address.getByName(ip).getHostAddress());
//        }
    }
}



