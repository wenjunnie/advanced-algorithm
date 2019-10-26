package firstpractice.practice2;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定一个矩形区域,每一个位置上都是1或0,求该矩阵中每一个位置上都是1的最大子矩形区域中的1的个数。
 * @Author: wenjun
 * @Date: 2019/10/12 1:19
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        while (first -- > 0) {
            int second = sc.nextInt();
            int third = sc.nextInt();
            int[][] heights = new int[second][third];
            for(int i = 0; i < second; i++) {
                for(int j = 0; j < third; j++) {
                    int forth = sc.nextInt();
                    heights[i][j] = forth;
                }
            }
            new Main().changeArr(heights);
        }
    }

    public void changeArr(int[][] heights) {
        int maxSquare = 0;
        for(int i = 0; i < heights[0].length; i++) {
            for(int j = 1; j < heights.length;j++) {
                if(heights[j-1][i] > 0 && heights[j][i] != 0) heights[j][i] = heights[j-1][i] + 1;
            }
        }
        int arr[] = new int[heights[0].length];
        for(int i = 0; i < heights.length; i++) {
            System.arraycopy(heights[i],0,arr,0,arr.length);
            maxSquare = Math.max(maxSquare,largestRectangleArea(arr));
        }
        System.out.println(maxSquare);
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for(int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] <= heights[stack.peek()])
                maxarea = Math.max(maxarea,heights[stack.pop()] * (i-stack.peek()-1));
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea,heights[stack.pop()] * (heights.length-stack.peek()-1));
        }
        return maxarea;
    }
}
