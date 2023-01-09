package src.LeetCode;

public class Leetcode1806 {
    public int reinitializePermutation(int n) {
        //如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
        //如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
        int[] arr = new int[n];
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        boolean eq;
        int count = 0;
        while (true) {
            eq = true;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) /2];
                }
                if (arr[i] != i) {
                    eq = false;
                }

            }
            count++;
                if (eq) {
                    return count;
                }
                for (int j = 0; j < n; j++) {
                    perm[j] = arr[j];
                }
        }
    }
}
