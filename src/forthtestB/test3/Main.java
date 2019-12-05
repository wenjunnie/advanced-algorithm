package forthtestB.test3;

import java.util.*;

/**
 * @Author: wenjun
 * @Date: 2019/12/2 20:17
 */
public class Main {

    static boolean[] flag;
    static List<List<Integer>> lists = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int tmp = Integer.parseInt(sc.nextLine());
            int[] arr = stringToArr(sc.nextLine().trim());
            flag = new boolean[10];
            backup(arr,tmp,new ArrayList<>());
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < lists.size(); i++) {
                int sum = 0;
                for (int j = 0; j < lists.get(i).size(); j++) {
                    sum += lists.get(i).get(j);
                }
                max = Math.max(sum,max);
            }
            System.out.println(lists);
            lists.clear();
        }
    }

    public static void backup(int[] nums, int length, List<Integer> list) {
        if (list.size() <= length && list.size() != 0) {
            lists.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            int[] arr = new int[nums.length - i - 1];
            System.arraycopy(nums,i+1,arr,0,arr.length);
            String s = String.valueOf(nums[i]);
            boolean flag1 = false;
            for (int j = 0; j < s.length(); j++) {
                if (flag[Integer.parseInt(String.valueOf(s.charAt(j)))]) {
                    flag1 = true;
                    break;
                }
            }
            if (!flag1) {
                list.add(nums[i]);
                for (int j = 0; j < s.length(); j++) {
                    flag[Integer.parseInt(String.valueOf(s.charAt(j)))] = true;
                }
            }
            backup(arr,length,list);
            if (!flag1) {
                list.remove(list.size() - 1);
                for (int j = 0; j < s.length(); j++) {
                    flag[Integer.parseInt(String.valueOf(s.charAt(j)))] = false;
                }
            }
        }
    }

    public static int[] stringToArr(String s) {
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }
}
