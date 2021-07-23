package CamupsRecruitTecent;

import java.util.Scanner;

/**
 * @author hyy
 * @date 2019/8/17 20:37
 */
public class TecentTest2 {
    public void sort(int[] begin, int[] end){

        for (int i = 0; i < begin.length; i++) {
            for (int j = 0; j < begin.length-i-1; j++) {
                if ((begin[j] > begin[j+1])||(begin[j] == begin[j+1] && end[j] < end[j+1])){
                    int temp = begin[j];
                    begin[j] = begin[j+1];
                    begin[j+1] = temp;
                    temp = end[j];
                    end[j] = end[j+1];
                    end[j+1] = temp;
                }
            }
        }

    }
    public int find(int[] begin,int[] end,int now,int l,int i,int j){
        int max = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (begin[i]<=now ){
                int temp = find(begin,end,end[k],l,k+1,j)+1;
                max = max<temp?max:temp;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        int[] end = new int[n];
        int[] begin = new int[n];
        for (int i = 0; i < n; i++) {
            begin[i] = in.nextInt();
            end[i] = in.nextInt();
        }
        TecentTest2 t = new TecentTest2();
        t.sort(begin,end);
        int now = 0;
        int count = 0;
        for (int i = 0; i < begin.length; i++) {
            if (begin[i] <= now){
                now = end[i];
                count ++;
                for (int j = begin.length-1; j > i; j--) {
                    if (begin[j] <= end[i]){
                        i = j-1;
                    }
                }
            }
        }
        System.out.println(count);
        //System.out.println(t.find(begin,end,0,l,0,n));

    }
}
