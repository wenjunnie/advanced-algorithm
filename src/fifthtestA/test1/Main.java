package fifthtestA.test1;

import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/11/28 10:28
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t -- > 0) {
            int house = sc.nextInt();
            int pipe = sc.nextInt();
            int[] fromHouse = new int[house+1];
            int[] toHouse = new int[house+1];
            int[] fromCost = new int[house+1];
            for (int i = 0; i < pipe; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int v = sc.nextInt();
                fromHouse[y] = x;
                toHouse[x] = y;
                fromCost[x] = v;
            }
            int num = 0;
            for (int i = 1; i <= house; i++) {
                if (fromHouse[i] == 0 && toHouse[i] != 0) num++;
            }
            System.out.println(num);
            for (int i = 1; i <= house; i++) {
                if (fromHouse[i] != 0 || toHouse[i] == 0) continue;
                int j = i;
                int cost = Integer.MAX_VALUE;
                while (toHouse[j] != 0) {
                    cost = Math.min(cost, fromCost[j]);
                    j = toHouse[j];
                }
                System.out.println(i + " " + j + " " + cost);
            }
        }
    }
}
