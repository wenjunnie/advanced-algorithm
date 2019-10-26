package secondpractice.practice3;

import java.util.Scanner;

/**
 * 将单个链表的每K个节点之间逆序，打印出新链表；最后不足K的节点数不需要逆序；要求时间复杂度为O(n)，额外空间复杂度为O(1)。
 * @Author: wenjun
 * @Date: 2019/10/26 12:48
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            int second = Integer.parseInt(sc.next());
            String[] arr = new String[second];
            for (int i = 0; i < second; i++) {
                arr[i] = sc.next();
            }
            int third = Integer.parseInt(sc.next());
            result(arr,third);
        }
    }

    public static void result(String[] arr, int num) {
        int cycle = arr.length/num;
        for (int i = 0; i < cycle; i++) {
            int x = 1;
            for (int j = i*num; j < i*num+num/2; j++) {
               String temp = arr[j];
               arr[j] = arr[(i+1)*num-x];
               arr[(i+1)*num-x++] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length-1)
                System.out.print(arr[i] + " ");
            else System.out.print(arr[i] + "\n");
        }
    }
}
