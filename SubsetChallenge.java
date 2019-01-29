package com.ajira;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubsetChallenge {


    public static void main(String args[]) throws Exception {
        InputStreamReader ISR = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ISR);

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int lengthInput = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] arr = str.split(" ");
            int chargeSum = charge(arr);
            System.out.println(chargeSum);

        }


    }

    static int charge(String[] arrystring) {
        int length = arrystring.length - 1;
        int noofSubsets = (int) Math.pow(2, length);
        int sum = 0;
        int mod = 1000000007;

        for (String item : arrystring) {

            int ai = Integer.parseInt(item);
            if (ischarged(ai, noofSubsets)) {
                sum +=  ai % mod;
            }

        }
        return sum % mod;
    }

    static boolean ischarged(int ai, int noofSubsets) {
        if (ai >= noofSubsets) {
            return true;
        } else {
            return false;
        }
    }

}
