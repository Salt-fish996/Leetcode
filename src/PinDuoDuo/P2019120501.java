package PinDuoDuo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hyy
 * @date 2019/12/5 19:03
 */
public class P2019120501 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (k > n){
            System.out.println("error");
        }
        int[] low1 = new int[n];
        int[] high1 = new int[n];
        int[] low2 = new int[n];
        int[] high2 = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int low = in.nextInt();
            int high = in.nextInt();
            min = Math.min(low,min);
            max = Math.max(max,high);
            low1[i] = low;
            high1[i] = high;
            low2[i] = low;
            high2[i] = high;
        }
        int lowResult = Integer.MAX_VALUE;
        int highResult = Integer.MAX_VALUE;
        if (k == 1){
            System.out.println(min + " " + max);
        }else {
            //找最小点
            int count = 0;
            for (int i = min; i <= max; i++) {
                count = 0;
                for (int j = 0; j < n; j++) {
                    if (low2[j] <= i && high2[j] >= i){
                        count++ ;
                    }
                }
                if (count >= k){
                    lowResult = i;
                    break;
                }
            }
          for (int i = max; i >= min; i--) {
                count = 0;
                for (int j = 0; j < n; j++) {
                    if (low2[j] <= i && high2[j] >= i){
                        count ++ ;
                    }
                }
                if (count >= k){
                    highResult = i;
                    break;
                }
            }
            if (highResult != Integer.MAX_VALUE && lowResult != Integer.MAX_VALUE){
                System.out.println(lowResult + " "+highResult);
            }else {
                System.out.println("error");
            }
        }


    }
}
