package firstpractice.practice5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 找到给定数组的给定区间内的第K小的数值。
 * @Author: wenjun
 * @Date: 2019/10/10 14:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        while (first -- > 0) {
            scanner.nextLine();
            List<Integer> list = new ArrayList<>();
            String second = scanner.nextLine();
            int third = scanner.nextInt();
            int forth = scanner.nextInt();
            int fifth = scanner.nextInt();
            String[] split = second.trim().split(" ");
            for(String key : split) list.add(Integer.valueOf(key));
            new Main().result(list,third,forth,fifth);
        }
    }

    public void result(List<Integer> list, int left, int right, int total) {
        List<Integer> list1 = new ArrayList<>();
        for(int i = left-1; i < right && i < list.size(); i++) {
            list1.add(list.get(i));
        }
        Collections.sort(list1);
        System.out.println(list1.get(total-1));
    }
}
