package fifthtestA.test4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/11/28 9:20
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int[] arr1 = stringToArr(sc.nextLine());
            int[] arr2 = stringToArr(sc.nextLine());
            Arrays.sort(arr2);
            System.out.println(solve(arr2,arr1[1]));
        }
    }

    public static int solve(int[] arr, int mount) {
        int sum = 0;
        for (int i = arr.length-1; i >= 0; ) {
            if (arr[i] <= mount) {
                sum++;
                mount -= arr[i];
            } else i--;
        }
        if (sum == 0 || mount != 0) return -1;
        else return sum;
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
