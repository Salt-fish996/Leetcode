package src.LeetCode;

import java.util.Arrays;

/**
 * @author hyy
 * @date 2020/3/22 15:55
 */
//通过
public class Leetcode945 {

    public int minIncrementForUnique(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        //首先将A进行排序
        Arrays.sort(A);
        int temp = A[0];
        int result = 0;
        System.out.println(Arrays.toString(A));

        for (int i = 1; i < A.length; i++) {
            if (A[i] > temp) {
                temp = A[i];
            } else {
                result += temp - A[i] + 1;
                A[i] = temp +1;
                temp ++;
            }
        }
        System.out.println(Arrays.toString(A));
//        int result =  minCount(A,A.length);
//        System.out.println(Arrays.toString(A));
        return result;

    }

    public static void main(String[] args) {
        Leetcode945 leetcode945 = new Leetcode945();
        System.out.println(leetcode945.minIncrementForUnique(new int[]{3,2,1,2,1,7}));
    }
}
