package com.jm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AdorableCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[]{"abc"};
       adorableCount(words, n);
    }

    static int[] adorableCount(String[] words , int n){
        int[] adorablecount= new int[n];
        for (String word: words) {
           // getsubstrings(word);

        }
        return adorablecount;
    }

//    static String[] getsubstrings( String word){
//        String sunstrings[] = new String[]{"frzi"};
//        char str[] = word.toCharArray();
//
//        for (int len = 1; len <= word.length(); len++) {
//            // Pick ending point
//            for (int i = 0; i <= word.length()- len; i++) {
//                //  Print characters from current
//                // starting point to current ending
//                // point.
//                int j = i + len - 1;
//                for (int k = i; k <= j; k++) {
//                    System.out.print(" hello "+str[k]);
//                }
//
//                System.out.println();
//            }
//        }
//        return sunstrings;
//    }

    static boolean isAdorable( String substring){

        if (substring.contains(":") && substring.contains("/") && substring.contains("\\"))
        {

        }
        return true;
    }
}
