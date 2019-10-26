package firsttest.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * A[]按B[]排序，例如A={2,1,2,5,7,1,9,3,6,8,8},B={2,1,8,3},RESULT={2,2,1,1,8,8,3,5,6,7,9}
 * @Author: wenjun
 * @Date: 2019/9/26 19:57
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int third = sc.nextInt();
        while (third-- > 0) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            int[] arr1 = new int[first];
            int[] arr2 = new int[second];
            for(int i = 0; i < first; i++) {
                int fourth = sc.nextInt();
                arr1[i] = fourth;
            }
            for(int i = 0; i < second; i++) {
                int fifth = sc.nextInt();
                arr2[i] = fifth;
            }
            List<Integer> list = new ArrayList<>();
            list = new Main().sort(arr1,arr2);
            StringBuilder builder = new StringBuilder();
            for(Integer key : list) builder.append(Integer.toString(key) + " ");
            System.out.print(builder.toString().trim()+"\n");
        }
    }

    public List<Integer> sort(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        if(arr2.length == 0) return list;
        for(int i = 0; i < arr2.length; i++) {
            for(int j = 0; j < arr1.length; j++) {
                if(arr1[j] == arr2[i]) list.add(arr2[i]);
            }
        }
        List<Integer> list1 = new ArrayList<>();
        for (int key : arr1) {
            if(!list.contains(key)) list1.add(key);
        }
        Collections.sort(list1);
        list.addAll(list1);
//        for(Integer key : list) System.out.println(key);
        return list;
    }
}
