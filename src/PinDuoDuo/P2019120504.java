package PinDuoDuo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author hyy
 * @date 2019/12/5 20:06
 */
public class P2019120504 {
    public static int dfs(HashMap<Integer,Integer> w,int last,int index,int n){
        if (index > n){
            return 0;
        }
        if (index == n){
            return 1;
        }

        if (w.containsKey(index)){
            if (last == w.get(index)){
                return 0;
            }else {
                return dfs(w,w.get(index),index + 1,n);
            }
        }

        int count = 0;
        for (int i = 1; i <= 4; i++) {
            if (i != last){
                count += dfs(w,i,index+1,n);
                count = count % 1000000007;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-->=0){
            int n = in.nextInt();
            int m = in.nextInt();
            if (m == 0){
                long count = 4;
                for (int i = 0; i < n - 1; i++) {

                    count *=3;
                    count = count % 1000000007;

                }
                System.out.println(count);
            }else {
                int[] w = new int[m];
                int[] c = new int[m];
                for (int i = 0; i < m; i++) {
                    w[i] = in.nextInt();
                }
                HashMap<Integer,Integer> hashMap = new HashMap<>();
                for (int i = 0; i < m; i++) {
                    c[i] = in.nextInt();
                    hashMap.put(w[i],c[i]);
                }
                System.out.println(dfs(hashMap,0,0,n));
            }
        }
    }
}
