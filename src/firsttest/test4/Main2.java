package firsttest.test4;

import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/12/4 19:40
 */
public class Main2 {

    public static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t -- > 0) {
            int num = Integer.parseInt(sc.nextLine());
            int[] arr = stringToArr(sc.nextLine());
            result(arr,0,num-1);
            System.out.println(sum);
            sum = 0;
        }
    }

    public static void result(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right-left) / 2;
            result(arr,left,mid);
            result(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int p1 = left, p2 = left, p3 = mid+1;
        int[] temp = new int[arr.length];
        while (left <= mid && p3 <= right) {
            if (arr[left] <= arr[p3]) {
                temp[p1++] = arr[left++];
            } else {
                temp[p1++] = arr[p3++];
                sum += mid-left+1;
            }
        }
        while (left <= mid) {
            temp[p1++] = arr[left++];
        }
        while (p3 <= right) {
            temp[p1++] = arr[p3++];
        }
        while (p2 <= right) arr[p2] = temp[p2++];
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
