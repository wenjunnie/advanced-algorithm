package fifthtestA.test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/12/4 0:58
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine().trim());
        while (first -- > 0) {
            int second = Integer.parseInt(sc.nextLine().trim());
            int[] arr1 = stringToArr(sc.nextLine().trim());
            int[] arr2 = stringToArr(sc.nextLine().trim());
            Arrays.sort(arr2);
            System.out.println(solve(arr1,arr2));
        }
    }

    public static int solve(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int max = 0, cur = 0;
        int i = 0, j = 0;
        while (i < arr1.length && j < arr1.length) {
            if (arr1[i] < arr2[j]) {
                cur++;
                i++;
                max = Math.max(cur,max);
            } else {
                j ++;
                cur --;
            }
        }
        return max;
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
