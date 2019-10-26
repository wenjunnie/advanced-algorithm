package firstpractice.practice1;

import java.util.Scanner;

/**
 * 给定数组arr和整数num,求arr的连续子数组中满足:其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为 O(n)的算法。
 * @Author: wenjun
 * @Date: 2019/10/12 1:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            sc.nextLine();
            String second = sc.nextLine();
            int third = sc.nextInt();
            String[] split = second.split(" ");
            int[] arr = new int[split.length];
            for(int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            new Main().result(arr, third);
        }
    }

    /**
     * 暂时不知道时间复杂度为O(n)的解法
     * @param arr
     * @param num
     */
    public void result(int[] arr, int num) {
        int result = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(Math.abs(arr[i] - arr[j]) > num) {
                    result += arr.length-j;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
