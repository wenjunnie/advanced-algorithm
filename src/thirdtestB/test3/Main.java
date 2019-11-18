package thirdtestB.test3;

import java.util.Scanner;

/**
 * Archana is very fond of strings. She likes to solve many questions related to strings.
 * She comes across a problem which she is unable to solve. Help her to solve. The problem
 * is as follows: Given is a string of length L. Her task is to find the longest string from
 * the given string with characters arranged in descending order of their ASCII code and in
 * arithmetic progression. She wants the common difference should be as low as possible
 * (at least 1) and the characters of the string to be of higher ASCII value.
 * @Author: wenjun
 * @Date: 2019/10/31 21:24
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            String s = sc.nextLine();
            result(s);
        }
    }

    public static void result(String s) {

    }
}
