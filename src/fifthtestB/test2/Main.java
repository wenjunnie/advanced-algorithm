package fifthtestB.test2;

import java.util.Scanner;

/**
 * 格子里的整数
 * @Author: wenjun
 * @Date: 2019/11/30 23:33
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            int[] arr = stringToArr(sc.nextLine());
            int[][] arr2 = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr2[i][j] = arr[i*n+j];
                }
            }
            System.out.println(result(arr2, n));
        }
    }

    public static int result(int[][] arr, int n) {
        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + arr[i][j];
            }
        }
        return dp[n-1][n-1];
    }

    public static int[] stringToArr(String s) {
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }
}
