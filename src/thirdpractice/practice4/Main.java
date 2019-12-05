package thirdpractice.practice4;

import java.util.Scanner;

/**
 * 棋盘覆盖
 * 1
 * 1 1 1
 * 0 0
 * @Author: wenjun
 * @Date: 2019/11/20 23:32
 */
public class Main {

    static class myException extends RuntimeException{}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        while (first -- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String[] split1 = s1.split(" ");
            String[] split2 = s2.split(" ");
            int n = Integer.parseInt(split1[0]);
            int x = Integer.parseInt(split1[1]);
            int y = Integer.parseInt(split1[2]);
            int goalX = Integer.parseInt(split2[0]);
            int goalY = Integer.parseInt(split2[1]);
            int length = (int)Math.pow(2,n);
            String[][] str = new String[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    str[i][j] = i + " " + j;
                }
            }
            str[x][y] = "A";
            str[goalX][goalY] = "A";
            try {
                result(str,length,x,y,goalX,goalY);
            } catch (myException e) {}
        }
    }

    public static void result(String[][] arr, int n, int x, int y, int goalX, int goalY) {
        int tmp = n/2;
        if (n == 2) {
            int index = 1;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (!arr[i][j].equals("A")) {
                        if (index == 1) {
                            System.out.print(arr[i][j] + ",");
                            index++;
                        } else System.out.print(arr[i][j] + "\n");
                    }
                }
            }
            throw new myException();
        }
        String[][] str = new String[tmp][tmp];
        if (goalX < tmp && goalY < tmp) {
            for (int i = 0; i < tmp; i++) {
                for (int j = 0; j < tmp; j++) {
                    str[i][j] = arr[i][j];
                }
            }
            if (x < tmp && y < tmp) {
                result(str,n/2,x,y,goalX,goalY);
            } else {
                if (goalX == tmp-1 && goalY == tmp-1) {
                    if (x < tmp && y >= tmp) {
                        System.out.println(arr[tmp][tmp-1]+","+arr[tmp][tmp]);
                        throw new myException();
                    }
                    if (x >= tmp && y < tmp) {
                        System.out.println(arr[tmp-1][tmp] + ","+arr[tmp][tmp]);
                        throw new myException();
                    }
                    if (x >= tmp && y >= tmp) {
                        System.out.println(arr[tmp-1][tmp]+","+arr[tmp][tmp-1]);
                        throw new myException();
                    }
                }
                str[tmp-1][tmp-1] = "A";
                result(str,n/2,tmp-1,tmp-1,goalX,goalY);
            }
        } else if (goalX < tmp && goalY >= tmp) {
            for (int i = 0; i < tmp; i++) {
                for (int j = 0; j < tmp; j++) {
                    str[i][j] = arr[i][j+tmp];
                }
            }
            if (x < tmp && y >= tmp) {
                result(str,n/2,x,y-tmp,goalX,goalY-tmp);
            } else {
                if (goalX == tmp-1 && goalY-tmp == 0) {
                    if (x < tmp && y < tmp) {
                        System.out.println(arr[tmp][tmp-1]+","+arr[tmp][tmp]);
                        throw new myException();
                    }
                    if (x >= tmp && y < tmp) {
                        System.out.println(arr[tmp-1][tmp-1] + "," + arr[tmp][tmp]);
                        throw new myException();
                    }
                    if (x >= tmp && y >= tmp) {
                        System.out.println(arr[tmp-1][tmp-1]+","+arr[tmp][tmp-1]);
                        throw new myException();
                    }
                }
                str[tmp-1][0] = "A";
                result(str,n/2,tmp-1,0,goalX,goalY-tmp);
            }
        } else if (goalX >= tmp && goalY < tmp) {
            for (int i = 0; i < tmp; i++) {
                for (int j = 0; j < tmp; j++) {
                    str[i][j] = arr[i+tmp][j];
                }
            }
            if (x >= tmp && y < tmp) {
                result(str,n/2,x-tmp,y,goalX-tmp,goalY);
            } else {
                if (goalX-tmp == 0 && goalY == tmp-1) {
                    if (x < tmp && y < tmp) {
                        System.out.println(arr[tmp-1][tmp] + "," + arr[tmp][tmp]);
                        throw new myException();
                    }
                    if (x < tmp && y >= tmp) {
                        System.out.println(arr[tmp-1][tmp-1] + "," + arr[tmp][tmp]);
                        throw new myException();
                    }
                    if (x >= tmp && y >= tmp) {
                        System.out.println(arr[tmp-1][tmp-1] + "," + arr[tmp-1][tmp]);
                        throw new myException();
                    }
                }
                str[0][tmp-1] = "A";
                result(str,n/2,0,tmp-1,goalX-tmp,goalY);
            }
        } else if (goalX >= tmp && goalY >= tmp) {
            for (int i = 0; i < tmp; i++) {
                for (int j = 0; j < tmp; j++) {
                    str[i][j] = arr[i+tmp][j+tmp];
                }
            }
            if (x >= tmp && y >= tmp) {
                result(str,n/2,x-tmp,y-tmp,goalX-tmp,goalY-tmp);
            } else {
                if (goalX-tmp == 0 && goalY-tmp == 0) {
                    if (x < tmp && y < tmp) {
                        System.out.println(arr[tmp-1][tmp] + "," + arr[tmp][tmp-1]);
                        throw new myException();
                    }
                    if (x < tmp && y >= tmp) {
                        System.out.println(arr[tmp-1][tmp-1] + "," + arr[tmp][tmp-1]);
                        throw new myException();
                    }
                    if (x >= tmp && y < tmp) {
                        System.out.println(arr[tmp-1][tmp-1] + "," + arr[tmp-1][tmp]);
                        throw new myException();
                    }
                }
                str[0][0] = "A";
                result(str,n/2,0,0,goalX-tmp,goalY-tmp);
            }
        }
    }
}
