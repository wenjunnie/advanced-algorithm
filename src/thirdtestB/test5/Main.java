package thirdtestB.test5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given an array of strings A[ ], determine if the strings can be chained together to form a circle.
 * A string X can be chained together with another string Y if the last character of X is same as first character of Y.
 * If every string of the array can be chained, it will form a circle. For example, for the array arr[] = {"for", "geek", "rig", "kaf"}
 * the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf".
 * @Author: wenjun
 * @Date: 2019/10/31 20:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            long second = Long.parseLong(sc.nextLine());
            String s = sc.nextLine();
            String[] split = s.split(" ");
            System.out.println(result(split));
        }
    }

    public static int result(String[] arr) {
        int length = 0;
        StringBuilder builder = new StringBuilder(arr[0]);
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            length += arr[i].length();
        }
        for (int i = 1; i < arr.length;) {
            boolean flag = false;
            if (builder.charAt(builder.length()-1) == arr[i].charAt(0) && !set.contains(i)) {
                builder.append(arr[i]);
                set.add(i);
                i = 0;
                flag = true;
            }
            if ((!flag && i == arr.length-1) || builder.length() == length) break;
            i++;
        }
        if (builder.charAt(0) == builder.charAt(builder.length()-1) && builder.length() == length) return 1;
        return 0;
    }
}
