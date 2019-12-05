package secondpractice.practice6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/12/4 10:53
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] arr = stringToArr(sc.nextLine());
            int[] arr2 = new int[arr.length-1];
            System.arraycopy(arr,1,arr2,0,arr2.length);
            Arrays.sort(arr2);
            for (int i = 0; i < arr2.length; i++) {
                if (i != arr2.length-1) {
                    System.out.print(arr2[i] + " ");
                } else System.out.print(arr2[i] + "\n");
            }
        }
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
