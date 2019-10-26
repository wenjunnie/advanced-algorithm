package firstpractice.practice8;

import java.util.Scanner;

/**
 * 有两个序列a、b,大小都为n,通过交换a、b中的元素,使序列a的和与序列b的和之间差的绝对值最小。
 * 当需要交换多次而不是一次更小时此解法错误，如[-3,9,10,65][6,9,10,55]结果应当为0。
 * @Author: wenjun
 * @Date: 2019/10/10 21:14
 */
public class MainRuntime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        while (first -- > 0) {
            String second = scanner.nextLine();
            String third = scanner.nextLine();
            String[] split1 = second.trim().split(" ");
            String[] split2 = third.trim().split(" ");
            int[] arr1 = new int[split1.length];
            int[] arr2 = new int[split2.length];
            for(int i = 0; i < split1.length; i++) {
                arr1[i] = Integer.parseInt(split1[i]);
            }
            for(int i = 0; i < split2.length; i++) {
                arr2[i] = Integer.parseInt(split2[i]);
            }
            new MainRuntime().result(arr1,arr2);
        }
    }

    public void result(int[] arr1,int[] arr2) {
        int sumA = 0,sumB = 0,flag = 1;
        for(int i = 0; i < arr1.length; i++) {
            sumA += arr1[i];
        }
        for(int i = 0; i < arr2.length; i++) {
            sumB += arr2[i];
        }
        double divided = (double) (sumA+sumB)/2;
        while (flag == 1) {
            flag = 0;
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    //一定是<=而不是<，特例[5,5,9,10],[4,7,7,13]
                    if (arr1[i] != arr2[j] && (Math.abs(sumA - arr1[i] + arr2[j] - divided) <= Math.abs(sumA - divided))) {
                        sumA = sumA - arr1[i] + arr2[j];
                        sumB = sumB - arr2[j] + arr1[i];
                        int temp = arr1[i];
                        arr1[i] = arr2[j];
                        arr2[j] = temp;
                        flag = 1;
                    }
                }
            }
        }
        System.out.println(Math.abs(sumA-sumB));
    }
}
