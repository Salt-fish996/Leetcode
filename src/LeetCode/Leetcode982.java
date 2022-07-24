package src.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author hyy
 * @date 2019/11/28 13:15
 */
public class Leetcode982 {
    public int countTriplets(int[] A) {

        int n = A.length;
        int count = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                hashMap.put(A[i] & A[j],hashMap.getOrDefault(A[i] & A[j],0) + 1);
            }
        }
        if (hashMap.containsKey(0)){
            count += n * hashMap.get(0);
            hashMap.remove(0);
        }
        for (int k = 0; k < n; k++) {
            for (Integer i:hashMap.keySet()
                 ) {
                if ((i & A[k]) == 0){
                    count += hashMap.get(i);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Leetcode982 leetcode982 = new Leetcode982();
        int[] a = new int[1000];
        for (int i = 0; i <1000; i++) {
            a[i] = (int) ((Math.pow(2,16)) * Math.random() + 1);
        }

        long s = System.currentTimeMillis();
        System.out.println(leetcode982.countTriplets(a) +" "+ (System.currentTimeMillis() - s));
        System.out.println(Arrays.toString(a));
    }
}
