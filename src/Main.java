import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: wenjun
 * @Date: 2019/11/11 18:48
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int first = sc.nextInt();
            for (int i = first;; i++) {
                if (isDigsum(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static boolean isDigsum(int num) {
        List<Integer> list = new ArrayList<>();
        int dig = result(num);
        if (judgePrime(num)) {
            return false;
        }
        for (int i = 2;;) {
            if (num % i == 0) {
                list.add(i);
                num /= i;
            } else i++;
            if (judgePrime(num)) {
                list.add(num);
                break;
            }
        }
        int dig2 = 0;
        for (int i = 0; i < list.size(); i++) {
            dig2 += result(list.get(i));
        }
        if (dig == dig2) return true;
        return false;
    }

    public static int result(int num) {
        int dig = 0;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length(); i++) {
            dig += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return dig;
    }

    public static boolean judgePrime(int num) {
        boolean flag = true;
        if(num == 1 || (num %2 == 0 && num !=2)) flag = false;
        else for(int j = 3; j <= Math.sqrt(num); j+=2) {
            if(num%j == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
