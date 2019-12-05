package thirdpractice.practice1;

import java.util.*;

/**
 * 给N个人分配N个任务，使代价最小，第一个数表示人员，第二个数表示任务，第三个数表示代价。
 * 1
 * 4
 * 2 1 6,1 2 2,1 3 7,1 4 8,1 1 9,2 2 4,2 3 3,2 4 7,3 1 5,3 2 8,3 3 1,3 4 8,4 1 7,4 2 6,4 3 9,4 4 4
 * @Author: wenjun
 * @Date: 2019/11/19 15:40
 */
public class Main {

    static boolean[] visited;
    static List<String> lists = new ArrayList<>();
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int second = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine();
            lists.clear();
            stack.clear();
            String[] split = s.split(",");
            visited = new boolean[second];
            int[][] arr = new int[second][second];
            for (int i = 0; i < split.length; i++) {
                String[] split2 = split[i].split(" ");
                int people = Integer.parseInt(split2[0]);
                int task = Integer.parseInt(split2[1]);
                int cost = Integer.parseInt(split2[2]);
                arr[people-1][task-1] = cost;
            }
            result(arr,0,0,second,new ArrayList<>());
            Collections.sort(lists, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] split1 = o1.split(" ");
                    String[] split2 = o2.split(" ");
                    for (int i = 0; i < split1.length; i++) {
                        if (!split1[i].equals(split2[i])) {
                            return Integer.parseInt(split2[i]) - Integer.parseInt(split1[i]);
                        }
                    }
                    return 0;
                }
            });
            for (int i = 0; i < lists.size(); i++) {
                if (i == lists.size()-1) System.out.print(lists.get(i) + "\n");
                else System.out.print(lists.get(i) + ",");
            }
        }
    }

    public static void result(int[][] arr, int row, int total, int n, List<String> list) {
        if (row == n) {
            if (stack.isEmpty()) stack.push(total);
            else if (total < stack.peek()) {
                lists.clear();
                stack.pop();
                stack.push(total);
            }
            if (lists.isEmpty() || total <= stack.peek()) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size()-1) builder.append(list.get(i));
                    else builder.append(list.get(i)).append(" ");
                }
                lists.add(builder.toString());
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int tmp = arr[row][i];
                visited[i] = true;
                list.add(String.valueOf(i+1));
                result(arr, row + 1, total + tmp, n, list);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
