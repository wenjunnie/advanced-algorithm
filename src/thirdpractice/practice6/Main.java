package thirdpractice.practice6;

import java.util.*;

/**
 * 图的广度优先遍历
 * @Author: wenjun
 * @Date: 2019/11/19 0:50
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            String s1 = sc.nextLine();
            String[] str = s1.split(" ");
            int num = Integer.parseInt(str[0]);
            char start = str[1].charAt(0);
            List<String> list = new ArrayList<>();
            for (int i = 0; i <= num; i++) {
                list.add(sc.nextLine());
            }
            result(list, start);
        }
    }

    public static void result(List<String> list, char start) {
        if (list.size() == 0) {
            System.out.println(start);
            return;
        }
        Queue<Character> queue = new ArrayDeque<>();
        List<Character> set = new ArrayList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            char tmp = queue.poll();
            set.add(tmp);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).charAt(0) == tmp) {
                    for (int j = 0; j < list.get(i).length(); j++) {
                        if (list.get(i).charAt(j) == '1' && !queue.contains(list.get(j/2).charAt(0)) && !set.contains(list.get(j/2).charAt(0))) {
                            queue.offer(list.get(j/2).charAt(0));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < set.size(); i++) {
            if (i == set.size()-1) {
                System.out.print(set.get(i) + "\n");
            } else System.out.print(set.get(i) + " ");
        }
    }
}
