package firstpractice.practice4;

import java.util.Scanner;

/**
 * 汉诺塔问题中限制不能将一层塔直接从最左侧移动到最右侧,也不能直接从最右侧移动到最左侧,
 * 而是必须经过中间。求当有N层塔的时候移动步数。
 * @Author: wenjun
 * @Date: 2019/10/10 23:16
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        while (first -- > 0) {
            int second = scanner.nextInt();
            new Main().result(second);
        }
    }

    public void result(int step) {
        int[] arr = new int[step];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = (int)Math.pow(3,i+1)-1;
        }
        System.out.println(arr[step-1]);
    }
}
