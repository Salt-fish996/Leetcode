package PinDuoDuo;

import java.util.Scanner;

/**
 * @author hyy
 * @date 2019/12/5 19:27
 */
public class P2019120502 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] bao = new int[n];
        int[] deduce = new int[n];
        //记录当前可以吃的豆沙包
        int count = n;
        for (int i = 0; i < n; i++) {
            bao[i] = in.nextInt();
            deduce[i] = in.nextInt();
        }

        while (count >= m){
            int first = -1;
            int second = -1;
            //记录位置
            int ssit = -1;
            int sesit = -1;
            //找出两个最美味的
            for (int i = 0; i < n; i++) {
                if (bao[i] > 0){
                    if (bao[i] > first){
                        second = first;
                        sesit = ssit;
                        first = bao[i];
                        ssit = i;
                    }else if (bao[i] == first){
                        if (deduce[i] > deduce[ssit]){
                            second = first;
                            sesit = ssit;
                            first = bao[i];
                            ssit = i;
                        }else {
                            if (bao[i] > second){
                                second = bao[i];
                                sesit = i;
                            }else if (deduce[i] > deduce[sesit]){
                                second = bao[i];
                                sesit = i;
                            }
                        }
                    }else if (second < bao[i]){
                        second = bao[i];
                        sesit = i;
                    }
                }
            }

            //将两个最美味的吃掉
            if (ssit >= 0)
            {
                bao[ssit] = -1;
                count--;
            }
            if (sesit >= 0){
                bao[sesit] = -1;
                count--;
            }



            //下降
            for (int i = 0; i < n; i++) {
                if (bao[i] > 0){
                    bao[i] = Math.max((bao[i] - deduce[i]), 0);
                    if (bao[i] == 0){
                        count --;
                    }
                }
            }
            if (count < m){
                for (int i = 0; i < n; i++) {
                    System.out.println(bao[i]);
                }
            }
        }


    }
}
