package WangyiRecruit;

import java.util.Scanner;

public class Main {
//    public static int Sum(int d){
//        String str = Integer.toString(d);
//        int sum = 0;
//        for (int i = 0; i < str.length(); i++) {
//            sum += str.charAt(i) - '0';
//        }
//        return sum;
//    }
    public static String find(int d){
        String result = "";
        while (d>=1) {
            if (d <= 9) {
                return d+result;
            }
            result += "9";
            d = d-9;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int digit = in.nextInt();
            System.out.println(find(digit));
//            int j = 1;
//            while (Sum(j) < digit){
//                j++;
//            }
//            System.out.println(j);
        }
    }
}
