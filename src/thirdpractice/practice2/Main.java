package thirdpractice.practice2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * KD树构造和查找
 * 对给定的点集合构造KD树，要求如下：将方差最大的维度作为当前的分割维度，
 * 将数据集在分割维度上排序后的中位数作为分割点。程序要检索给定点对应的最近的K个点的坐标。
 * 1
 * 3 5,6 2,5 8,9 3,8 6,1 1,2 9
 * 8.2 4.6
 * 2
 * @Author: wenjun
 * @Date: 2019/12/5 14:40
 */
class DataNode {
    double Distance;
    String Loc;

    public DataNode(double distance, String loc) {
        Distance = distance;
        Loc = loc;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int caseNum = Integer.parseInt(cin.nextLine().trim());
        while (caseNum-- > 0) {
            String[] input1 = cin.nextLine().trim().split(",");
            double[] locationOfIndex = StringarrToDoublearr(cin.nextLine().trim());
            int K = Integer.parseInt(cin.nextLine().trim());
            DataNode[] nodeList = new DataNode[input1.length];
            for (int i = 0; i < input1.length; i++) {
                nodeList[i] = new DataNode(Math.pow(Double.parseDouble(input1[i].split(" ")[0]) - locationOfIndex[0], 2) + Math.pow(Double.parseDouble(input1[i].split(" ")[1]) - locationOfIndex[1], 2), input1[i]);
            }
            Arrays.sort(nodeList, (o1, o2) -> (int) (o1.Distance - o2.Distance));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < K; i++) {
                double x = Double.parseDouble(nodeList[i].Loc.split(" ")[0]);
                double y = Double.parseDouble(nodeList[i].Loc.split(" ")[1]);
                if (x == (int) x)
                    sb.append((int) x);
                else
                    sb.append(x);
                sb.append(" ");
                if (y == (int) y)
                    sb.append((int) y);
                else
                    sb.append(y);
                sb.append(",");
            }
            System.out.println(sb.toString().substring(0, sb.length() - 1));
        }
    }

    public static double[] StringarrToDoublearr(String str) {
        String[] inputS = str.split(" ");
        double[] output = new double[inputS.length];
        for (int i = 0; i < inputS.length; i++) {
            output[i] = Double.parseDouble(inputS[i]);
        }
        return output;
    }
}
