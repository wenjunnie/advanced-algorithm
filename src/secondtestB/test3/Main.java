package secondtestB.test3;

import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/10/17 19:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            int second = sc.nextInt();
            int[] arr = new int[second];
            for (int i = 0; i < second; i++) {
                arr[i] = sc.nextInt();
            }
            int third = sc.nextInt();
            findBook(arr,second,third);
        }
    }

    static void findBook(int[] arr, int book, int student) {
        int dp[][] = new int[student+1][book+1];
        for (int i = 1; i <= book; i++) {
            dp[1][i] = sum(arr,0,i-1);
        }
        for (int i = 1; i <= student; i++) {
            dp[i][1] = arr[0];
        }
        for (int i = 2; i <= student; i++) {
            for (int j = 2; j <= book; j++) {
                int max = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    max = Math.min(max,Math.max(dp[i-1][k],sum(arr,k,j-1)));
                }
                dp[i][j] = max;
            }
        }
        System.out.println(dp[student][book]);
    }

    static int sum(int[] arr, int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++) {
            total += arr[i];
        }
        return total;
    }
}
