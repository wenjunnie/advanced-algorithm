package firstpractice.practice6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个数组和一个数字,在数组中查找两个数,使得它们的和正好是输入的那个数字，统计这样两个数的对数。
 * @Author: wenjun
 * @Date: 2019/10/10 13:24
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
            String[] split = second.trim().split(" ");
            for(String key : split) list.add(Integer.valueOf(key));
            new Main().result(list,third);
        }
    }

    public void result(List<Integer> list, int total) {
        Collections.sort(list);
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < list.size()-1; i++) {
            for (int j = i; j < list.size(); j++) {
                if(list.get(i) + list.get(j) == total) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(list.get(i));
                    list1.add(list.get(j));
                    if(!lists.contains(list1)) lists.add(list1);
                }
            }
        }
        System.out.println(lists.size());
    }
}
