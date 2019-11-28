package thirdpractice.practice8;

import java.util.*;

/**
 * 排序（出现次数多的在前，次数相同小的在前）
 * @Author: wenjun
 * @Date: 2019/11/19 0:33
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            int second = sc.nextInt();
            int[] arr = new int[second];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            result(arr);
        }
    }

    public static void result(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        if (arr.length == 0) {
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) map.put(arr[i],1);
            else map.put(arr[i],map.get(arr[i])+1);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue().intValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
            else return o2.getValue().compareTo(o1.getValue());
        });
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i).getValue();
            for (int j = 0; j < num; j++) {
                if (i == list.size()-1 && j == num-1) System.out.print(list.get(i).getKey() + "\n");
                else System.out.print(list.get(i).getKey() + " ");
            }
        }
    }
}
