package thirdtestB.test5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 能否成环
 * @Author: wenjun
 * @Date: 2019/12/3 23:48
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int second = Integer.parseInt(sc.nextLine());
            String[] arr = stringToArr(sc.nextLine());
            System.out.println(result(arr));
        }
    }

    public static int result(String[] arr) {
        String s = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].length();
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            list.add(arr[i]);
        }
        if (list.size() == 0) {
            if (s.charAt(0) == s.charAt(s.length()-1))
                return 1;
            else return 0;
        }
        for (int i = 0; i < list.size();) {
            if (list.get(i).charAt(0) == s.charAt(s.length()-1)) {
                s = s + list.get(i);
                list.remove(i);
                i = 0;
            } else i++;
        }
        if (s.length() == sum && s.charAt(0) == s.charAt(s.length()-1)) return 1;
        else return 0;
    }

    public static String[] stringToArr(String s) {
        String[] split = s.split(" ");
        return split;
    }
}
