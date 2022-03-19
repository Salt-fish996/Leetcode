package CamupsRecruitTecent;

import java.util.Scanner;

/**
 * @author hyy
 * @date 2019/9/1 19:51
 */
public class Tecent201909011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] ns = new int[n];
        int[] ms = new int[m];
        for (int i = 0; i < n; i++) {
            ns[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            ms[i] = in.nextInt();
        }
        int nsjishu = 0;
        int nsoushu = 0;
        int msjishu = 0;
        int msoushu = 0;
        for (int i = 0; i < n; i++) {
            if (ns[i]%2 == 0){
                nsoushu++;
            }else
                nsjishu ++;
        }

        for (int i = 0; i < m; i++) {
            if (ms[i] %2==0){
                msoushu++;
            }else msjishu++;
        }

        int result = (Math.min(nsjishu, msoushu))+(Math.min(nsoushu, msjishu));
        System.out.println(result);
    }
}
