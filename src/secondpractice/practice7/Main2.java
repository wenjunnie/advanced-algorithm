package secondpractice.practice7;

import java.util.Scanner;
import java.util.Stack;

/**
 * 实现递归快速排序
 * @Author: wenjun
 * @Date: 2019/10/27 3:30
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine().trim();
            int[] arr = StringToArr(s);
            int[] arr2 = new int[arr.length-1];
            System.arraycopy(arr,1,arr2,0,arr2.length);
            result(arr2,0,arr2.length-1);
            print(arr2);
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

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length-1)
                System.out.print(arr[i] + " ");
            else System.out.print(arr[i] + "\n");
        }
    }

    /**
     * 递归实现
     * @param arr
     * @param left
     * @param right
     */
    public static void result(int[] arr,int left, int right) {
        int l = left, r = right;
        int key = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= key) {
                right --;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        if (left-1 > l)
            result(arr,l,left-1);
        if (left+1 < r)
            result(arr,left+1,r);
    }
}
