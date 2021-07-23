package CamupsRecruitTecent;

import java.util.Scanner;

/**
 * @author hyy
 * @date 2019/9/1 20:10
 */
public class Tecent201909012 {
    public static int min = Integer.MAX_VALUE;
    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void quanpailie(int[] a1,int[] a2,int sum,int begin,int n){
        if (begin == n-1){
            int temp = a1[begin]*(begin+1) +a2[begin];
            sum += temp>0?temp:0;
            if (sum<min){
                min = sum;
            }
        }else if (sum >=min) return;
        else {
            for (int i = begin; i < n; i++) {

                swap(a1,begin,i);
                swap(a2,begin,i);
                int temp = a1[begin]*(begin+1) +a2[begin];
                temp = temp>0?temp:0;
                quanpailie(a1,a2,sum+temp,begin+1,n);
                swap(a1,begin,i);
                swap(a2,begin,i);

            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] cha = new int[n];
        int[] bubian = new int[n];
        for (int i = 0; i < n; i++) {
            int tempa = in.nextInt();
            int tempb = in.nextInt();

            cha[i] = tempa-tempb;
            bubian[i] = tempb*n-tempa;
        }
        Tecent201909012 t = new Tecent201909012();
        t.quanpailie(cha,bubian,0,0,n);
        System.out.println(min);
    }
}
