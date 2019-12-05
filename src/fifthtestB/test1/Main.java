package fifthtestB.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/11/30 17:41
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            sc.nextLine();
            int[] road1 = stringToArr(sc.nextLine());
            int[] road2 = stringToArr(sc.nextLine());
            System.out.println(result(road1,road2));
        }
    }

    public static int result(int[] road1, int[] road2) {
        List<Integer> road1Index = new ArrayList<>();
        List<Integer> road2Index = new ArrayList<>();
        List<Integer> sum1Index = new ArrayList<>();
        List<Integer> sum2Index = new ArrayList<>();
        road1Index.add(-1);
        road2Index.add(-1);
        for (int i = 0; i < road1.length; i++) {
            for (int j = 0; j < road2.length; j++) {
                if (road1[i] == road2[j]) {
                    road1Index.add(i);
                    road2Index.add(j);
                }
            }
        }
        for (int i = 1; i < road1Index.size(); i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = road1Index.get(i-1)+1; j <= road1Index.get(i); j++) {
                sum1 += road1[j];
            }
            for (int j = road2Index.get(i-1)+1; j <= road2Index.get(i); j++) {
                sum2 += road2[j];
            }
            sum1Index.add(sum1);
            sum2Index.add(sum2);
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int i = road1Index.get(road1Index.size()-1)+1; i < road1.length; i++) {
            sum1 += road1[i];
        }
        for (int i = road2Index.get(road2Index.size()-1)+1; i < road2.length; i++) {
            sum2 += road2[i];
        }
        sum1Index.add(sum1);
        sum2Index.add(sum2);
        int sum = 0;
        for (int i = 0; i < sum1Index.size(); i++) {
            sum += Math.max(sum1Index.get(i),sum2Index.get(i));
        }
        return sum;
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
