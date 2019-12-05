package secondtestB.test2;

import java.util.*;

/**
 * 和最大的连续降序字符
 * @Author: wenjun
 * @Date: 2019/11/30 16:12
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            char[] arr = sc.nextLine().trim().toCharArray();
            Arrays.sort(arr);
            System.out.println(result(arr));
        }
    }

    public static String result(char[] c) {
        Set<Character> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < c.length; i++) {
            set.add(c[i]);
        }
        for (int i = c.length-1; i >= 0; i--) {
            char tmp = c[i];
            String s = String.valueOf(tmp);
            for (int j = 1; j <= 25;) {
                char a = (char)(tmp-j);
                if (set.contains(a)) {
                    s = s + a;
                    tmp = a;
                } else {
                    list.add(s);
                    tmp = c[i];
                    s = String.valueOf(tmp);
                    j++;
                }
            }
        }
        int length = 0;
        for (int i = 0; i < list.size(); i++) {
            length = Math.max(length,list.get(i).length());
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == length) return list.get(i);
        }
        return null;
    }
}
