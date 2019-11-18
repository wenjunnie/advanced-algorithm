package thirdtestA.test4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[])
 * that prints all occurrences of pat[] in txt[]. You may assume that n > m.
 * @Author: wenjun
 * @Date: 2019/10/31 9:55
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long first = Long.parseLong(sc.nextLine().trim());
        while (first -- > 0) {
            String s1 = sc.nextLine();
            result(s1);
        }
    }

    public static void result(String s3) {
        String[] split = s3.split(",");
        String s1 = split[0];
        String s2 = split[1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length() - s2.length() + 1; i++) {
            String s = s1.substring(i,i+s2.length());
            if (s.equals(s2)) list.add(i);
        }
        if (list.size() == 0) System.out.println();
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size()-1)
                System.out.print(list.get(i) + " ");
            else System.out.print(list.get(i) + "\n");
        }
    }
}
