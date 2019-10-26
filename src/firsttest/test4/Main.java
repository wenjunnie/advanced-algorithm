package firsttest.test4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * i<j但A[i]>A[j]称为一个倒置，求数组中所有倒置数，要求O(nlogn)
 * @Author: wenjun
 * @Date: 2019/9/26 19:29
 */
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
        int sum = 0;
        for(int i = 0; i < list.size()-1; i++) {
            for(int j = i; j < list.size(); j++) {
                if(list.get(i) > list.get(j) && i < j) sum++;
            }
        }
        System.out.println(sum);
    }
}
