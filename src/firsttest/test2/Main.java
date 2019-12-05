package firsttest.test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 返回使数组从小到大排序的最小交换次数
 * 1
 * 12
 * 64 65 1 22 50 48 29 38 16 0 2 78
 * @Author: wenjun
 * @Date: 2019/9/26 19:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int third = sc.nextInt();
        while (third-- > 0) {
            int first = sc.nextInt();
            int[] arr = new int[first];
            for(int i = 0; i < first; i++) {
                int second = sc.nextInt();
                arr[i] = second;
            }
            new Main().sort(arr);
        }
    }

    public void sort(int[] arr) {
        int sum = 0;
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr,0,arr2,0,arr.length);
        Arrays.sort(arr2);
        label:
        for(int i = 0; i < arr2.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == arr2[i] && i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    sum++;
                    continue label;
                }
            }
        }
        System.out.println(sum);
    }
}
