package forthtestB.test1;

import java.util.Scanner;

/**
 * 是否能通过考试
 * 1
 * 5 40 21
 * 12 10
 * 16 10
 * 20 10
 * 24 10
 * 8 3
 * @Author: wenjun
 * @Date: 2019/11/27 23:43
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int[] arr1 = stringToArr(sc.nextLine());
            int[] time = new int[arr1[0]];
            int[] score = new int[arr1[0]];
            for (int i = 0; i < arr1[0]; i++) {
                int[] tmp = stringToArr(sc.nextLine());
                time[i] = tmp[0];
                score[i] = tmp[1];
            }
            int res = solve(time,score,arr1[1],arr1[2]);
            if (res != 0) {
                System.out.println("YES " + res);
            } else System.out.println("NO");
        }
    }

    public static int solve(int[] time, int[] score, int timeLimit, int scoreLimit) {
        int row = time.length;
        int[][] dp = new int[row+1][timeLimit+1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = timeLimit; j >= time[i-1]; j--) {
                if (time[i-1] <= j)
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-time[i-1]]+score[i-1]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i][j] >= scoreLimit)
                    return j;
            }
        }
        return 0;
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
