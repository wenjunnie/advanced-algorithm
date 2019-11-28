package forthtestA.test1;

import java.util.*;

/**
 * @Author: wenjun
 * @Date: 2019/11/21 9:10
 */
public class Main {

    static List<Double> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine().trim());
        while (first -- > 0) {
            int second = Integer.parseInt(sc.nextLine());
            String s = sc.nextLine().trim();
            double[] arr = stringToArr(s);
            list.clear();
            double sum = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr.length == 1) {
                    list.add(arr[0]);
                    break;
                }
                if (i != 0) sum += arr[i];
                if (arr[i] < 0) {
                    double[] arr2 = new double[arr.length-1];
                    for (int j = 0; j < arr.length; j++) {
                        if (j < i) arr2[j] = arr[j];
                        if (j > i) arr2[j-1] = arr[j];
                    }
                    result(arr2);
                }
            }
            list.add(sum);
            Collections.sort(list);
            System.out.printf("%.0f\n",list.get(list.size()-1));
            System.out.println(list.get(list.size()-1).intValue());
        }
    }

    public static double[] stringToArr(String s) {
        String[] split = s.split(" ");
        double[] arr = new double[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(split[i]);
        }
        return arr;
    }

    public static void result(double[] arr) {
        double sum = 0;
        double res = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (sum >= 0) sum += arr[i];
            else {
                sum = arr[i];
            }
            res = Math.max(res,sum);
        }
        list.add(res);
    }
}
