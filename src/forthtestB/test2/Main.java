package forthtestB.test2;

import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/12/2 20:17
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int n = Integer.parseInt(sc.nextLine().trim());
            System.out.println(solve(n));
        }
    }

    public static int solve(int n) {
        int[] c = {0,0,1,1,1,0,1};
        int[][] dp = new int[n][n];
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (c[(int)Math.pow((i+1)%7*(j+1)%7, 3) %7] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
