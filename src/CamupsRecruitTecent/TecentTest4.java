package CamupsRecruitTecent;

import java.util.Scanner;

/**
 * @author hyy
 * @date 2019/8/17 21:11
 */
public class TecentTest4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] high = new int[n];
        int[] count = new int[n];
        int[] before = new int[n];
        int[] after = new int[n];
        for (int i = 0; i < n; i++) {
            high[i] = in.nextInt();
            before[i] = 0;
            int temp = i;
            if (temp > 1){
                before[temp] = 1;
                if (high[temp]>= high[temp-1]){
                    before[temp] += before[temp-1];
                }
            }

        }

        for (int i = n-1; i >= 0; i--) {
            if (i<=n-2){
                after[i] = 1;
                if (high[i] >= high[i+1]){
                    after[i] += after[i+1];
                }

            }
            count[i] = after[i]+before[i]+1;
        }



        for (int i = 0; i < n; i++) {
            System.out.print(count[i] +" ");
        }
    }
}
