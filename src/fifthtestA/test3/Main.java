package fifthtestA.test3;

import java.util.*;

/**
 * @Author: wenjun
 * @Date: 2019/11/28 9:50
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine().trim());
        while (first -- > 0) {
            int second = Integer.parseInt(sc.nextLine().trim());
            int[] arr = stringToArr(sc.nextLine().trim());
            int[] id = new int[second];
            int[] deadline = new int[second];
            int[] profit = new int[second];
            int index = 0;
            for (int i = 0; i < arr.length; i+=3) {
                id[index] = arr[i];
                deadline[index] = arr[i+1];
                profit[index] = arr[i+2];
                index++;
            }
            System.out.println(solve(deadline,profit,second));
        }
    }

    public static String solve(int[] deadline, int[] profit, int n) {
        int sum = 0;
        boolean[] flag = new boolean[n];
        List<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < deadline.length; i++) {
            if (list3.size() == 0 || !list3.contains(deadline[i])) {
                list3.add(deadline[i]);
            }
        }
        Collections.sort(list3);
        int temp = list3.get(list3.size()-1);
        for (int i = 1; i <= list3.size(); i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int j = 0; j < deadline.length; j++) {
                if (deadline[j] <= temp && !flag[j]) {
                    list.add(profit[j]);
                    list2.add(j);
                }
            }
            if (list.size() != 0) {
                int min = Integer.MIN_VALUE;
                int index = -1;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) > min) {
                        min = list.get(j);
                        index = j;
                    }
                }
                sum += list.get(index);
                flag[list2.get(index)] = true;
                if (deadline[list2.get(index)] <= i) {
                    for (int j = 0; j < deadline.length; j++) {
                        if (deadline[j] == deadline[list2.get(index)]) flag[j] = true;
                    }
                }
            }
        }
        return list3.size() + " " + sum;
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
