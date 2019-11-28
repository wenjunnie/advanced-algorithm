package forthtestA.test3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/11/21 9:26
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            int second = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < second; i++) {
                list.add(sc.nextInt());
            }
            result(list);
        }
    }

    public static void result(List<Integer> list) {
        Collections.sort(list);
        int sum = 0;
        while (list.size() != 0) {
            int tmp = list.get(list.size()-1);
            sum += tmp;
            list.remove(list.size()-1);
            if (list.size() != 0) {
                if (list.get(list.size()-1) == tmp-1) list.remove(list.size()-1);
            }
        }
        System.out.println(sum);
    }
}
