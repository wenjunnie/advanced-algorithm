package secondtestA.test4;

import java.util.Scanner;

/**
 * 有9个因数的数
 * @Author: wenjun
 * @Date: 2019/11/28 17:32
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            long second = sc.nextLong();
            System.out.println(result(second));
        }
    }

    public static int result(long num) {
        int limit = (int)Math.sqrt(num);
        int[] arr = new int[limit+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 2; i*i <= limit; i++) {
            for (int j = i*i; j <= limit; j += i) {
                if (arr[j] == j) arr[j] = i;
            }
        }
        int sum = 0;
        for (int i = 2; i <= limit; i++) {
            int p = arr[i];
            int q = arr[i/arr[i]];
            if (p * q == i && q != 1 && p != q) {
                sum++;
            } else if (Math.pow(i,8) <= num && judgePrime(i)) {
                sum++;
            }
        }
        return sum;
    }

    public static boolean judgePrime(int n) {
        // 默认n!=1
        if (n % 2 == 0 && n != 2) return false;
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
