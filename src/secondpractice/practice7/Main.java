package secondpractice.practice7;

import java.util.Scanner;
import java.util.Stack;

/**
 * 实现非递归快速排序
 * @Author: wenjun
 * @Date: 2019/10/27 3:30
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine().trim();
            int[] arr = StringToArr(s);
            QuickSort(arr,0,arr.length-1);
            print(arr);
        }
    }

    /**
     * 非递归实现
     * @param arr
     * @param left
     * @param right
     */
    public static int result(int[] arr,int left, int right) {
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
        return left;
    }

    public static void QuickSort(int[] arr, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        stack.push(left);
        stack.push(right);
        while (!stack.isEmpty()) {
            int r = stack.pop();
            int l = stack.pop();
            int index = result(arr,l,r);
            if (index-1 > l) {
                stack.push(l);
                stack.push(index-1);
            }
            if (index+1 < r) {
                stack.push(index+1);
                stack.push(r);
            }
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
//    public static void result(int[] arr,int left, int right) {
//        int l = left, r = right;
//        int key = arr[left];
//        while (left < right) {
//            while (left < right && arr[right] >= key) {
//                right --;
//            }
//            arr[left] = arr[right];
//            while (left < right && arr[left] <= key) {
//                left++;
//            }
//            arr[right] = arr[left];
//        }
//        arr[left] = key;
//        if (left-1 > l)
//            result(arr,l,left-1);
//        if (right+1 < r)
//            result(arr,left+1,r);
//    }
}
