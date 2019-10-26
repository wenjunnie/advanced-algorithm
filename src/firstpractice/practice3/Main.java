package firstpractice.practice3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 给定个整型数组arr和一个大小为w的窗口,窗口从数组最左边滑动到最右边,
 * 每次向右滑动—个位置,求出每一次滑动时窗口内最大元素的和。
 * @Author: wenjun
 * @Date: 2019/10/10 18:25
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
        int num = 0;
        if(total == 0) System.out.println(num);
        for (int i = 0; i <= list.size()-total; i++) {
            List<Integer> list1 = new ArrayList<>(list.subList(i,i+total));
            Collections.sort(list1);
            num += list1.get(list1.size()-1);
        }
        System.out.println(num);
    }
}
