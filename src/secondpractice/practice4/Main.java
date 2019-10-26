package secondpractice.practice4;

import java.util.Scanner;

/**
 * 实现插入排序。
 * @Author: wenjun
 * @Date: 2019/10/26 13:14
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.next());
        while (first -- > 0) {
            int second = sc.nextInt();
            int[] arr = new int[second];
            for (int i = 0; i < second; i++) {
                arr[i] = sc.nextInt();
            }
            result(arr);
        }
    }

    public static void result(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                int temp = arr[i];
                for (int j = i; j >= 0; j--) {
                    if (j > 0 && arr[j-1] > temp) {
                        arr[j] = arr[j-1];
                    } else {
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length-1)
                System.out.print(arr[i] + " ");
            else System.out.print(arr[i] + "\n");
        }
    }
}
