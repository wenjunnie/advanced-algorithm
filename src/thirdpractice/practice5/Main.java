package thirdpractice.practice5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 图的深度优先遍历，打印最大深度
 * 1
 * 4 a
 * a b c d
 * a 0 1 1 0
 * b 1 0 1 0
 * c 1 1 0 1
 * d 0 0 1 0
 * @Author: wenjun
 * @Date: 2019/11/19 14:33
 */
public class Main {

    static boolean[] visited;
    static List<Integer> list2 = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            String s1 = sc.nextLine();
            String[] str = s1.split(" ");
            int num = Integer.parseInt(str[0]);
            visited = new boolean[num+1];
            char start = str[1].charAt(0);
            List<String> list = new ArrayList<>();
            for (int i = 0; i <= num; i++) {
                list.add(sc.nextLine());
            }
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).charAt(0) == start) {
                    DFS(list, 1, i);
                }
            }
            int result = 0;
            for (int i = 0; i < list2.size(); i++) {
                result = Math.max(result,list2.get(i));
            }
            System.out.println(result);
        }
    }

    public static void DFS(List<String> list, int depth, int dot) {
        if (!visited[dot]) {
            list2.add(depth);
        }
        visited[dot] = true;
        for (int i = 2; i < list.get(dot).length(); i++) {
            if (list.get(dot).charAt(i) == '1' && !visited[i/2]) {
                DFS(list, depth+1, i/2);
            }
        }
    }
}
