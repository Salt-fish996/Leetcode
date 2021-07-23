package CamupsRecruitTecent;

import java.util.Scanner;

/**
 * @author hyy
 * @date 2019/9/1 21:09
 */
public class Tecent201909013 {
    public static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] fenshu = new int[n];
        for (int i = 0; i < n; i++) {
            fenshu[i] = in.nextInt();
        }
        Tecent201909013 t = new Tecent201909013();
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int j = i; j < n; j++) {

                if (min>fenshu[j])
                    min = fenshu[j];
                sum +=fenshu[j];
                if (sum*min>MAX) MAX=sum*min;
            }
        }
        System.out.println(MAX);



    }
}
