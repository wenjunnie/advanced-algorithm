package forthtestB.test4;

import java.util.Scanner;

/**
 * 最小初始化点
 * @Author: wenjun
 * @Date: 2019/11/30 14:57
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int[] arr1 = stringToArr(sc.nextLine());
            int[] arr2 = stringToArr(sc.nextLine());
            int row = arr1[0];
            int col = arr1[1];
            int[][] arr = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    arr[i][j] = arr2[i*row+j];
                }
            }
            System.out.println(result(arr,row,col));
        }
    }

    public static int result(int[][] arr,int row,int col) {
        int[][] dp = new int[row][col];
        dp[row-1][col-1] = arr[row-1][col-1] < 0 ? -arr[row-1][col-1]+1 : 1;
        for (int i = row-2; i >= 0; i--) {
            dp[i][col-1] = Math.max(dp[i+1][col-1]-arr[i][col-1],1);
        }
        for (int i = col-2; i >= 0 ; i--) {
            dp[row-1][i] = Math.max(dp[row-1][i+1]-arr[row-1][i],1);
        }
        for (int i = row-2; i >= 0; i--) {
            for (int j = col-2; j >= 0; j--) {
                int min = Math.min(dp[i][j+1],dp[i+1][j]);
                dp[i][j] = Math.max(min-arr[i][j],1);
            }
        }
        return dp[0][0];
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
