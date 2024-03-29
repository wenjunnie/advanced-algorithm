package thirdtestA.test5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/10/31 12:45
 */
public class RightAnswer {

    static Map<Long, Long> map = new HashMap<Long, Long>();

    public static long fib(long n) {
        if (n == 0)
            return 0;
        if (n == 2 || n == 1)
            return 1;
        if (map.containsKey(n))
            return map.get(n);
        if (n % 2 != 0) {
            long k = (n + 1) / 2;
            map.put(n, (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) % 1000000007);
        } else {
            long k = n / 2;
            map.put(n, (fib(k) * ((fib(k - 1) << 1) + fib(k))) % 1000000007);

        }
        return map.get(n);
    }

    public static void main(String[] args) {
        Scanner ab = new Scanner(System.in);
        int t = ab.nextInt();
        while (t-- > 0) {
            System.out.println(fib(ab.nextLong() + 1));
        }
    }
}
