package thirdtestA.test1;

import java.util.Scanner;

/**
 * Given a string ‘str’ of digits, find length of the longest substring of ‘str’,
 * such that the length of the substring is 2k digits and sum of left k digits is
 * equal to the sum of right k digits.
 * @Author: wenjun
 * @Date: 2019/10/30 15:28
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long first = Long.parseLong(sc.nextLine().trim());
        while (first -- > 0) {
            String s = sc.nextLine();
            System.out.println(result(s));
        }
    }

    public static int result(String s) {
        int length = s.length();
        if (length % 2 == 0) {
            for (int i = s.length(); i > 0; i-=2) {
                for (int j = 0; j < s.length()-i+1; j++) {
                    String str = s.substring(j,j+i);
                    if (isTrue(str)) return i;
                }
            }
        } else {
            for (int i = s.length()-1; i > 0; i-=2) {
                for (int j = 0; j < s.length()-i+1; j++) {
                    String str = s.substring(j,j+i);
                    if (isTrue(str)) return i;
                }
            }
        }
        return 0;
    }

    public static boolean isTrue(String s){
        String s1 = s.substring(0,s.length()/2);
        String s2 = s.substring(s.length()/2);
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            sum1 += Integer.parseInt(String.valueOf(s1.charAt(i)));
            sum2 += Integer.parseInt(String.valueOf(s2.charAt(i)));
        }
        if (sum1 == sum2) return true;
        return false;
    }
}
