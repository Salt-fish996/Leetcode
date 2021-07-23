package WangyiRecruit;

import java.util.Scanner;

public class Wangyi3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();

            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = in.nextInt();
            }
            int max = 0;
            int begin = 0;
            for (int j = 0; j < n; j++) {
                int[] sums = new int[n];
                sums[0] = array[j];
                int sumcount = 1;
                int k = 0;
                for (k = j+1; k < n; k++) {
                    if (array[k] >= sums[sumcount-1] ){
                        sums[sumcount++] = sums[sumcount-1]+array[k];
                    }else break;
                }
                if (sumcount > max){
                    max = sumcount;

                }
            }
//            int max = 1;
//            sums[0] = array[0];
//            for (int j = 1; j < n; j++) {
//                sums[j] = sums[j-1] + array[j];
//                if (array[j] >= sums[j-1]){
//                    if (j+1 > max) max = j+1;
//                }else {
//                    for (int k = 0; k < j; k++) {
//                        if (sums[j-1] - sums[k] <= array[j]){
//                            if (j - k > max) max = j-k;
//                            break;
//                        }
//                    }
//                }
//            }
            System.out.println(max);
        }
    }
}
