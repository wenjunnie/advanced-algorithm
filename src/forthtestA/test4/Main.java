package forthtestA.test4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/11/21 9:33
 */
public class Main {

    static List<Integer> list = new ArrayList<>();
    static boolean[] flag;
    static boolean[] buy;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            int second = sc.nextInt();
            flag = new boolean[second+2];
            buy = new boolean[3];
            int[][] arr = new int[second][3];
            for (int i = 0; i < second; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            list.clear();
            result(arr,0,second,0,0);
            Collections.sort(list);
            System.out.println(list.get(0));
        }
    }

    public static void result(int[][] arr, int total, int second, int index, int tmp) {
        if (index == second) {
            list.add(total);
            return;
        }
        for (int i = 1; i < second+1; i++) {
            if (!flag[i]) {
                flag = new boolean[second+2];
                flag[i] = true;
                flag[i-1] = true;
                flag[i+1] = true;
                for (int j = 0; j < 3; j++) {
                    buy[j] = true;
                    result(arr,total+arr[i-1][j], second, index+1, j);
                    buy[j] = false;
                }
            } else {
                flag = new boolean[second+2];
                flag[i] = true;
                flag[i-1] = true;
                flag[i+1] = true;
                for (int j = 0; j < 3; j++) {
                    if (!buy[j]) {
                        //buy = new boolean[3];
                        buy[j] = true;
                        buy[tmp] = false;
                        result(arr,total+arr[i-1][j], second, index+1,j);
                        buy[j] = false;
                        buy[tmp] = true;
                    }
                }
            }
        }
    }
}
