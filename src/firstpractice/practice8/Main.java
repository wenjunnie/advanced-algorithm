package firstpractice.practice8;

import java.util.Scanner;

/**
 * 有两个序列a、b,大小都为n,通过交换a、b中的元素,使序列a的和与序列b的和之间差的绝对值最小。
 * https://www.cnblogs.com/mickole/articles/3613014.html
 * @Author: wenjun
 * @Date: 2019/10/12 2:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        while (first -- > 0) {
            String second = scanner.nextLine();
            String third = scanner.nextLine();
            String[] split1 = second.trim().split(" ");
            String[] split2 = third.trim().split(" ");
            int[] arr = new int[split1.length+split2.length];
            for(int i = 0; i < split1.length; i++) {
                arr[i] = Integer.parseInt(split1[i]);
            }
            for(int i = 0; i < split2.length; i++) {
                arr[i+split1.length] = Integer.parseInt(split2[i]);
            }
            System.out.println(new Main().result(arr));
        }
    }

    public int result(int[] arr) {
        int sum = 0,divide,half = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        divide = sum/2;
        boolean[][] dp = new boolean[arr.length/2+1][divide+1];
        dp[0][0] = true;
        for(int i = 1; i <= arr.length; i++) {
            for(int j = Math.min(i,arr.length/2); j >= 1; j--) {
                for(int k = 1; k <= divide; k++) {
                    if((k >= arr[i-1]) && dp[j-1][k-arr[i-1]]) {
                        dp[j][k] = true;
                    }
                }
            }
        }
        for(int i = 1; i <= divide; i++) {
            if(dp[arr.length/2][i]) half = Math.max(half,i);
        }
        return Math.abs(sum-2*half);
    }
}