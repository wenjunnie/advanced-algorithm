package thirdpractice.practice3;

import java.util.Scanner;

/**
 * 希尔排序
 * @Author: wenjun
 * @Date: 2019/11/19 14:09
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String[] split1 = s1.split(" ");
            String[] split2 = s2.split(" ");
            result(split1,split2);
        }
    }

    public static void result(String[] split1, String[] split2) {
        for (int i = 0; i < split2.length; i++) {
            for (int j = Integer.parseInt(split2[i]); j < split1.length; j++) {
                String tmp = split1[j];
                int k = 0;
                for (k = j; k >= Integer.parseInt(split2[i]) && Integer.parseInt(tmp) < Integer.parseInt(split1[k-Integer.parseInt(split2[i])]); k-=Integer.parseInt(split2[i]))
                {
                    split1[k] = split1[k-Integer.parseInt(split2[i])];
                }
                split1[k] = tmp;
            }
        }
        for (int i = 0; i < split1.length; i++) {
            if (i == split1.length-1)
                System.out.print(split1[i] + "\n");
            else System.out.print(split1[i] + " ");
        }
    }
}
