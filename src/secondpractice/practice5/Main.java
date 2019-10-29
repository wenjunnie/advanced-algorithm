package secondpractice.practice5;

import java.util.Scanner;

/**
 * 实现冒泡排序
 * @Author: wenjun
 * @Date: 2019/10/27 3:30
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int first = sc.nextInt();
            int[] arr = new int[first];
            for (int i = 0; i < first; i++) {
                arr[i] = sc.nextInt();
            }
            result(arr);
        }
    }

    public static void result(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length-1)
                System.out.print(arr[i] + " ");
            else System.out.print(arr[i] + "\n");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
