package thirdtestA.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array of positive integers and many queries for divisibility.
 * In every query Q[i], we are given an integer K , we need to count all
 * elements in the array which are perfectly divisible by K.
 * @Author: wenjun
 * @Date: 2019/10/31 9:07
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int second = sc.nextInt();
            int third = sc.nextInt();
            int[] arr1 = new int[second];
            int[] arr2 = new int[third];
            for (int i = 0; i < second; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < third; i++) {
                arr2[i] = sc.nextInt();
            }
//            String s1 = sc.nextLine().trim();
//            String s2 = sc.nextLine().trim();
//            int[] arr1 = StringToArr(s1);
//            int[] arr2 = StringToArr(s2);
            result(arr1,arr2);
        }
    }

    public static void result(int[] arr1,int[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            int index = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] % arr2[i] == 0) {
                    index++;
                }
            }
            list.add(index);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size()-1)
                System.out.print(list.get(i) + " ");
            else System.out.print(list.get(i) + "\n");
        }
    }

    public static int[] StringToArr(String s) {
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }
}
