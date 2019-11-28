package forthtestA.test2;

import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/11/21 9:17
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr2[i] = sc.nextInt();
            }
            result(arr1,arr2);
        }
    }

    public static void result(int[] arr1, int[] arr2) {
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            sum += Math.max(arr1[i],arr2[i]);
        }
        System.out.println(sum);
    }
}
