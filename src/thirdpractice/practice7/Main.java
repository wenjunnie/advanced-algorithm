package thirdpractice.practice7;

import java.util.*;

/**
 * 求拓扑排序解的个数
 * 1
 * a c,b c,c d,d e,d f,e g,f g
 * @Author: wenjun
 * @Date: 2019/11/19 14:52
 */
public class Main {

    static class myException extends RuntimeException{}
    static List<Integer> list2 = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            String s = sc.nextLine();
            String[] split = s.split(",");
            List<String> list = new ArrayList<>(Arrays.asList(split));
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < list.size(); i++) {
                set.add(list.get(i).charAt(0));
                set.add(list.get(i).charAt(2));
            }
            try {
                result(list, set.size());
            } catch (myException e) {}
            int result = 1;
            for (int i = 0; i < list2.size(); i++) {
                result *= list2.get(i);
            }
            System.out.println(result);
        }
    }

    public static void result(List<String> list, int dotNum) {
        if (list.size() == 0) {
            throw new myException();
        }
        Set<Character> setIn = new HashSet<>();
        Set<Character> setOut = new HashSet<>();
        Set<Character> setDif = new HashSet<>();
        List<Character> listOut = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listOut.add(list.get(i).charAt(0));
            setIn.add(list.get(i).charAt(2));
            setOut.add(list.get(i).charAt(0));
        }
        if (setIn.size() < dotNum) {
            list2.add(dotNum-setIn.size());
            for (int i = 0; i < listOut.size(); i++) {
                if (!setIn.contains(listOut.get(i))) {
                    setDif.add(listOut.get(i));
                }
            }
            for (int i = 0; i < list.size(); ) {
                if (setDif.contains(list.get(i).charAt(0))) {
                    list.remove(i);
                } else i++;
            }
            result(list,setIn.size());
        }
    }
}
