package secondpractice.practice8;

import java.util.Scanner;

/**
 * 归并排序非递归实现
 * @Author: wenjun
 * @Date: 2019/10/27 3:30
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine().trim();
            int[] arr = StringToArr(s);
            result(arr,0,arr.length-1);
            print(arr);
        }
    }

    public static void result(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            result(arr,left,mid);
            result(arr,mid+1,right);
            Merge(arr,left,mid,right);
        }
    }

    public static void Merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int p1 = left,p2 = left,p3 = mid+1;
        while (left <= mid && p3 <= right) {
            if (arr[left] <= arr[p3]) temp[p1++] = arr[left++];
            else temp[p1++] = arr[p3++];
        }
        while (left <= mid) {
            temp[p1++] = arr[left++];
        }
        while (p3 <= right) {
            temp[p1++] = arr[p3++];
        }
        while (p2 <= right) {
            arr[p2] = temp[p2++];
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
}
