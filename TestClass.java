import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestClass {


    public static void main(String args[]) throws Exception {


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String bin = sc.nextLine();

        TestClass test = new TestClass();
         System.out.println(test.findLongestSub(bin));
    }

    int findLongestSub(String bin) {
        int n = bin.length();
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> prevSum = new HashMap<Integer, Integer>();

        int currentLength;

        for (int i = 0; i < n; i++) {
            if (bin.charAt(i) == '0') {
                sum++;
            } else
                sum--;

            if (sum > 0) {
                maxLength = i + 1;
            }

            else if (sum <= 0) {
                if (prevSum.containsKey(sum - 1)) {
                    currentLength = i - prevSum.get(sum - 1);
                    maxLength = Math.max(maxLength, currentLength);
                }
            }

            if (!prevSum.containsKey(sum))
                prevSum.put(sum, i);
        }
        return maxLength;


    }
}
