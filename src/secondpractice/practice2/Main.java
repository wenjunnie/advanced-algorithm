package secondpractice.practice2;

import java.util.Scanner;

/**
 * 判断一个单向链表是否为回文结构。自定义链表数据结构，要求时间复杂度为O(n)，空间复杂度为O(1)。
 * @Author: wenjun
 * @Date: 2019/10/26 12:28
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int second = Integer.parseInt(sc.next());
            String s = sc.nextLine();
            result(s.trim());
        }
    }

    public static void result(String s) {
        StringBuilder builder = new StringBuilder(s);
        builder.reverse();
        System.out.println(builder.toString().equals(s));
    }
}
