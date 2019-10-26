package secondtestA.test3;

import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/10/17 10:15
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine().trim());
        while (first -- > 0) {
            result(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
    }

    public static void result(int a,int b,int c) {
        int ans = a%c;
        int mul = ans;
        for (int i = 1; i < b; i++) {
            ans = (ans*mul)%c;
        }
        System.out.println(ans);
    }
}
