package secondpractice.practice1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定两个字符串，返回两个字符串的最长公共子序列（不是最长公共子字符串），可能是多个。
 * @Author: wenjun
 * @Date: 2019/10/26 14:57
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            result(s1,s2);
        }
    }

    public static void result(String s1, String s2) {
        StringBuilder[][] strings = new StringBuilder[s1.length()+1][s2.length()+1];
        StringBuilder[][] strings2 = new StringBuilder[s1.length()+1][s2.length()+1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                strings[i][j] = new StringBuilder();
            }
        }
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                strings2[i][j] = new StringBuilder();
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    strings[i][j] = strings[i-1][j-1].length() >= strings[i][j-1].length() ? new StringBuilder(strings[i-1][j-1].append(s1.charAt(i-1))) : new StringBuilder(strings[i][j-1].append(s1.charAt(i-1)));
                    if (strings[i-1][j-1].length() >= strings[i][j-1].length()) {
                        strings[i-1][j-1].deleteCharAt(strings[i-1][j-1].length()-1);
                    } else {
                        strings[i][j-1].deleteCharAt(strings[i][j-1].length()-1);
                    }
                }
                else {
                    strings[i][j] = strings[i-1][j].length() > strings[i][j-1].length() ? strings[i-1][j] : strings[i][j-1];
                }
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    strings2[i][j] = strings2[i-1][j-1].length() >= strings2[i][j-1].length() ? new StringBuilder(strings2[i-1][j-1].append(s1.charAt(i-1))) : new StringBuilder(strings2[i][j-1].append(s1.charAt(i-1)));
                    if (strings2[i-1][j-1].length() >= strings2[i][j-1].length()) {
                        strings2[i-1][j-1].deleteCharAt(strings2[i-1][j-1].length()-1);
                    } else {
                        strings2[i][j-1].deleteCharAt(strings2[i][j-1].length()-1);
                    }
                }
                else {
                    strings2[i][j] = strings2[i-1][j].length() >= strings2[i][j-1].length() ? strings2[i-1][j] : strings2[i][j-1];
                }
            }
        }
        int length = strings[s1.length()][s2.length()].length();
        if (length != 0) {
            Set<String> set = new TreeSet<>();
            for (int i = 1; i <= s1.length(); i++) {
                for (int j = 1; j <= s2.length(); j++) {
                    if (strings[i][j].length() == length) {
                        set.add(strings[i][j].toString());
                    }
                    if (strings2[i][j].length() == length) {
                        set.add(strings2[i][j].toString());
                    }
                }
            }
            for (String str : set) {
                System.out.println(str);
            }
        }
    }
}
