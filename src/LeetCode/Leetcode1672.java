package src.LeetCode;

public class Leetcode1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int count = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                count += accounts[i][j];
            }
            max = Math.max(count,max);
        }
        return max;
    }
}
