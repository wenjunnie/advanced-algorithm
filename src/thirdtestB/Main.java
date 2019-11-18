package thirdtestB;

import java.util.*;

/**
 * @Author: wenjun
 * @Date: 2019/11/11 19:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<List<Integer>> lists = new ArrayList<>();
            int first = sc.nextInt();
            int second = sc.nextInt();
            for (int i = 0; i < second; i++) {
                List<Integer> list = new ArrayList<>();
                int third = sc.nextInt();
                int forth = sc.nextInt();
                list.add(third);
                list.add(forth);
                lists.add(list);
            }
            result(lists,first,second);
        }
    }

    public static void result(List<List<Integer>> lists, int spot, int rode) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < lists.size(); i++) {
            set.add(lists.get(i).get(0));
            set.add(lists.get(i).get(1));
        }
        System.out.println(spot-set.size());
    }
}
