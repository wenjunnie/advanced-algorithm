package forthtestA.test4;

import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/11/21 9:33
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int row = Integer.parseInt(sc.nextLine());
            int[][] arr = new int[row][3];
            for (int i = 0; i < row; i++) {
                arr[i] = stringToArr(sc.nextLine());
            }
            System.out.println(result(arr));
        }
    }

    public static int result(int[][] arr) {
        int[][] dp = new int[arr.length][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = arr[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]) + arr[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res,dp[arr.length-1][i]);
        }
        return res;
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
