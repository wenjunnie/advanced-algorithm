package thirdtestA.test5;

import java.util.*;

/**
 * 斐波那契数列
 * @Author: wenjun
 * @Date: 2019/10/31 10:31
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long first = sc.nextInt();
        while (first -- > 0) {
            long second = sc.nextLong();
            System.out.println(result(second));
        }
    }

//    public static long result(long year) {
//        if (year == 0) return 0;
//        if (year <= 2) return year;
//        LinkedList<Long> list = new LinkedList<>();
//        list.push(2L);list.push(1L);
//        for (int i = 2; i < year; i++) {
//            list.push((list.get(0)+list.get(1))%1000000007);
//            if (list.size() == 3) list.pollLast();
//        }
//        return list.get(list.size()-1)%1000000007;
//    }

    public static long result(long year) {
        Map<Long,Long> map = new HashMap<>();
        map.put(1L,1L);
        map.put(2L,2L);
        for (long i = 3; i <= year; i++) {
            map.put(i,(map.get(i-1)+map.get(i-2))%1000000007);
        }
        return map.get(year);
    }
}
