package thirdtestA.test3;

import java.util.Scanner;

/**
 * Consider a string A = "12345". An infinite string s is built by performing infinite steps on A recursively.
 * In i-th step, A is concatenated with ‘$’ i times followed by reverse of A. A=A|$...$|reverse(A), where | denotes concatenation.
 * @Author: wenjun
 * @Date: 2019/10/31 9:26
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long first = sc.nextLong();
        while (first -- > 0) {
            long second = sc.nextLong();
            String s = "12345";
            result(second,s,6L);
        }
    }

    public static void result(long dist,String s,long length) {
        StringBuilder builder1 = new StringBuilder(s);
        int index = 1;
        while ((long)builder1.length() < dist) {
            for (int i = 0; i < index; i++) {
                builder1.append("$");
            }
            StringBuilder builder2 = new StringBuilder(builder1);
            builder2.reverse();
            for (int i = 0; i < index; i++) {
                builder2.deleteCharAt(0);
            }
            builder1.append(builder2);
            index++;
        }
        builder1.reverse();
        System.out.println(builder1.charAt((int)(builder1.length()-dist)));
    }
}
