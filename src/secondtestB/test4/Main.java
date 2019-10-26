package secondtestB.test4;

import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/10/17 18:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            result(sc.nextLong());
        }
    }

    public static void result(long num) {
        int count = 0;
        long index = 1;
        while ((num - index*index) >= 0){
            num = num - (long)index*index;
            index++;
            count++;
        }
        System.out.println(count);
    }
}
