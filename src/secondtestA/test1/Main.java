package secondtestA.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/10/17 12:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine().trim());
        while (first -- > 0) {
            List<Integer> list = new ArrayList<>();
            int second = sc.nextInt();
            int third = sc.nextInt();
            for (int i = 0; i < third; i++) {
                list.add(sc.nextInt());
            }
//            result(list,second);
        }
    }
    static int best = Integer.MAX_VALUE;
//    public static int result(List<Integer> list, int num) {
//        if(num == 1) return sum(list);
//        if(num >= list.size()) return max(list);
//        for (int i = 0; i < list.size(); i++) {
//            best = Math.min(best,Math.max());
//        }
//        return best;
//    }

    public static int sum(List<Integer> list) {
        int sum = 0;
        for(Integer key : list) sum += key;
        return sum;
    }

    public static int max(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            max = Math.max(max,list.get(i));
        }
        return max;
    }
}
