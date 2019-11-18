package thirdtestB.test4;

import java.util.*;

/**
 * In a given cartesian plane, there are N points. We need to find the Number of Pairs of points(A,B) such that
 * Point A and Point B do not coincide.
 * Manhattan Distance and the Euclidean Distance between the points should be equal.
 * Note : Pair of 2 points(A,B) is considered same as Pair of 2 points(B,A).
 * Manhattan Distance = |x2-x1|+|y2-y1|
 * Euclidean Distance = ((x2-x1)^2 + (y2-y1)^2)^0.5 where points are (x1,y1) and (x2,y2).
 * Constraints:1<=T <= 50, 1<=N <= 2*10 ^ 5, 0<=(|Xi|, |Yi|) <= 10^9
 * @Author: wenjun
 * @Date: 2019/10/31 19:13
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            int second = sc.nextInt();
            long[][] arr = new long[second][2];
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = sc.nextLong();
                arr[i][1] = sc.nextLong();
            }
            System.out.println(result(arr));
        }
    }

    public static long result(long[][] arr) {
        long index = 0;
        Map<Long,Integer> map1 = new HashMap<>();
        Map<Long,Integer> map2 = new HashMap<>();
        Map<List<Long>,Integer> map3 = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map1.containsKey(arr[i][0])) {
                map1.put(arr[i][0],1);
            } else map1.put(arr[i][0],map1.get(arr[i][0])+1);
            if (!map2.containsKey(arr[i][1])) {
                map2.put(arr[i][1],1);
            } else map2.put(arr[i][1],map2.get(arr[i][1])+1);
        }
        for (int i = 0; i < arr.length; i++) {
            List<Long> list = new ArrayList<>();
            list.add(arr[i][0]);
            list.add(arr[i][1]);
            if (!map3.containsKey(list)) {
                map3.put(list,1);
            } else map3.put(list,map3.get(list)+1);
        }
        for (Long key : map1.keySet()) {
            index += map1.get(key) * (map1.get(key)-1) /2;
        }
        for (Long key : map2.keySet()) {
            index += map2.get(key) * (map2.get(key)-1) /2;
        }
        for (List<Long> key : map3.keySet()) {
            index -= map3.get(key) * (map3.get(key)-1) /2;
        }
        return index;
    }
}
