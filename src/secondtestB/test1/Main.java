package secondtestB.test1;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: wenjun
 * @Date: 2019/10/17 20:44
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            int N = sc.nextInt();
            int Q = sc.nextInt();
            long[] arr1 = new long[2 * N];
            long[] arr2 = new long[Q];
            for (int i = 0; i < 2 * N; i++) {
                arr1[i] = sc.nextLong();
            }
            for (int i = 0; i < Q; i++) {
                arr2[i] = sc.nextLong();
            }
            result(arr1, arr2, N, Q);
        }
    }

//    public static void result(long[]arr1,long[]arr2,int N, int Q){
//        List<Long> list = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            for (long j = arr1[2*i]; j <= arr1[2*i+1]; j++) {
//                list.add(j);
//            }
//        }
//        for (int i = 0; i < arr2.length; i++) {
//            if(i != arr2.length-1)System.out.print(list.get((int)arr2[i]-1) + " ");
//            else System.out.print(list.get((int)arr2[i]-1) + "\n");
//        }
//    }

    public static void result(long[]arr1,long[]arr2,int N, int Q){
        Stack<Long> stack1 = new Stack<>();
        Stack<Long> stack2 = new Stack<>();
        for (int i = 0; i < N; i++) {
            for (long j = arr1[2*i]; j <= arr1[2*i+1]; j++) {
                stack1.push(j);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if(i != arr2.length-1) {
                long x = stack1.size() - arr2[i];
                while (x -- > 0) {
                    long num = stack1.pop();
                    stack2.add(num);
                }
                System.out.print(stack1.peek() + " ");
                while (!stack2.isEmpty()) {
                    long num2 = stack2.pop();
                    stack1.push(num2);
                }
            }
            else {
                long m = stack1.size() - arr2[i];
                while (m -- > 0) {
                    long num = stack1.pop();
                    stack2.add(num);
                }
                System.out.print(stack1.peek() + "\n");
                while (!stack2.isEmpty()) {
                    long num2 = stack2.pop();
                    stack1.push(num2);
                }
            }
        }
    }
}
