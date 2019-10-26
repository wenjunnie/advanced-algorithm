package firsttest.test1;

/**
 * 对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，如果出现次数相同，则按照数值大小排序。
 * 例如，给定数组为{2,3,2,4,5,12,2,3,3,3,12}，则排序后结果为{3,3,3,3,2,2,2,12,12,4,5}。
 * @Author: wenjun
 * @Date: 2019/9/26 21:05
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int third = sc.nextInt();
        while (third-- > 0) {
            List<Integer> list = new ArrayList<>();
            int first = sc.nextInt();
            while (first-- > 0) {
                int second = sc.nextInt();
                list.add(second);
            }
            new Main().sort(list);
        }
    }

    public void sort(List<Integer> list) {
        List<Integer> list1 = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < list.size(); i++) {
            if(!map.containsKey(list.get(i))) {
                map.put(list.get(i), 1);
            }else {
                map.put(list.get(i), map.get(list.get(i))+1);
            }
        }
        List<Map.Entry<Integer, Integer>> list2 = new ArrayList<>(map.entrySet());
        Collections.sort(list2, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int re = o2.getValue().compareTo(o1.getValue());
                if(re != 0) return re;
                else return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(Map.Entry<Integer,Integer> key : list2) {
            for(int i = 0; i < key.getValue(); i++) {
                list1.add(key.getKey());
            }
        }
        for(Integer num : list1) System.out.print(num+" ");
    }
}