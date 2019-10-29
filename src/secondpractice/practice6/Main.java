package secondpractice.practice6;

import java.util.*;

/**
 * 实现计数排序
 * @Author: wenjun
 * @Date: 2019/10/27 3:30
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int first = sc.nextInt();
            int[] arr = new int[first];
            for (int i = 0; i < first; i++) {
                arr[i] = sc.nextInt();
            }
            result(arr);
        }
    }

    public static void result(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    num++;
                }
                map.put(i,num);
            }
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<Integer,Integer> key : list) {
            size++;
            if (size != map.size()) System.out.print(arr[key.getKey()] + " ");
            else System.out.print(arr[key.getKey()] + "\n");
        }
    }
}
