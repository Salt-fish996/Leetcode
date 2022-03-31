package LeetCode;

import java.math.BigInteger;

public class Leetcode2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        // 对于骰子，每次的数字必然在1-6之间
        int totalCount = mean*(n+rolls.length);
        for (int i = 0; i < rolls.length; i++) {
            totalCount = totalCount - rolls[i];
        }
        if (totalCount > 6 * n || totalCount < n) {
            return new int[]{};
        }
        // 剩下的n个数组成了值totalCount
        int[] arr = new int[n];
        while (totalCount >0) {
            for (int i = 0; i < n; i++) {
                if (totalCount > 0) {
                    arr[i] += 1;
                    totalCount--;
                }else {
                    break;
                }
            }
        }
        return arr;
    }
}
