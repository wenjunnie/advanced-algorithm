package thirdtestB.test1;

import java.util.*;

/**
 * 超时
 * Babul’s favourite number is 17. He likes the numbers which are divisible by 17.
 * This time what he does is that he takes a number N and tries to find the largest number
 * which is divisible by 17, by rearranging the digits. As the number increases he gets puzzled
 * with his own task. So you as a programmer have to help him to accomplish his task.
 * Note: If the number is not divisible by rearranging the digits, then print “Not Possible”.
 * N may have leading zeros.
 * @Author: wenjun
 * @Date: 2019/10/31 20:52
 */
public class Main{

    static class StopException extends RuntimeException{}

    static StringBuilder builder = new StringBuilder();
    static int index = 0;
    static boolean flag = false;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            builder = new StringBuilder();
            flag = false;
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            StringBuilder builder1 = new StringBuilder();
            for (int i = chars.length-1; i >= 0; i--) {
                builder1.append(chars[i]);
            }
            index = s.length();
            try {
                result(builder1.toString());
            } catch (StopException e) {
            }
            if (!flag) System.out.println("Not Possible");
        }
    }

    public static void result(String s){
        if (builder.length() == index && builder.charAt(0) != '0' && Long.parseLong(builder.toString()) % 17 == 0) {
            //list.add(builder.toString());
            flag = true;
            System.out.println(builder.toString());
            throw new StopException();
        }
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            StringBuilder builder2 = new StringBuilder(s);
            builder2.deleteCharAt(i);
            result(builder2.toString());
            if (builder.length() > 0) builder.deleteCharAt(builder.length()-1);
        }
    }

//    public static void result(String s) {
//        if (builder.length() == index) {
//            list.add(builder.toString());
//        }
//        for (int i = 0; i < s.length(); i++) {
//            builder.append(s.charAt(i));
//            StringBuilder builder2 = new StringBuilder(s);
//            builder2.deleteCharAt(i);
//            result(builder2.toString());
//            if (builder.length() > 0) builder.deleteCharAt(builder.length()-1);
//        }
//    }
//
//    public static void judge(List<String> list) {
//        List<Long> list1 = new ArrayList<>();
//        Collections.sort(list);
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).charAt(0) != '0' && Long.parseLong(list.get(i)) % 17 == 0) {
//                list1.add(Long.parseLong(list.get(i)));
//                break;
//            }
//        }
//        if (list1.isEmpty()) {
//            System.out.println("Not Possible");
//        } else System.out.println(list1.get(0));
//    }
}
