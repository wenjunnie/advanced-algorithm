package fifthtestA.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 时间分隔
 * @Author: wenjun
 * @Date: 2019/11/28 9:30
 */
public class Main {

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
        int sum = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] < arr2[i-1]) {
                boolean flag = false;
                for (int j = 0; j < list.size(); j++) {
                    if (arr1[i] <= list.get(j)) {
                        flag = true;
                        break;
                    }
                }
                if (list.isEmpty() || flag) {
                    sum++;
                    list.add(arr2[i-1]);
                }
            }
        }
        return sum;
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
