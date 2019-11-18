package thirdtestB.test2;

import java.util.Scanner;

/**
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only first such pair.
 * NOTE: A solution will always exist, read Goldbach’s conjecture.Also, solve the problem in linear time complexity, i.e., O(n).
 * @Author: wenjun
 * @Date: 2019/10/31 18:42
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            int second = sc.nextInt();
            result(second);
        }
    }

    public static void result(int num) {
        for (int i = 1; i <= num/2; i+=2) {
            if (judgePrime(i) && judgePrime(num - i)) {
                System.out.print(i + " " + (num - i) + "\n");
                break;
            }
        }
    }

    public static boolean judgePrime(int num) {
        boolean flag = true;
        if(num == 1 || (num %2 == 0 && num !=2)) flag = false;
        else for(int j = 3; j <= Math.sqrt(num); j+=2) {
            if(num%j == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
