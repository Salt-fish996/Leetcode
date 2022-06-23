package src.LeetCode;

public class Leetcode1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] dp = new int[s.length()+1];
        if (s.length() == 0) {
            return 0;
        }
        for (int i = 1; i <= dp.length; i++) {
            dp[i] = dp[i-1]+Math.abs(s.charAt(i)-t.charAt(i));
        }
        int res = 0;
        for (int i = 0; i <= s.length(); i++) {
           int start = binarySearch(dp,i,dp[i]-maxCost);
           res = Math.max(i-start,res);
        }
        return res;
    }

    public int binarySearch(int[] accDiff, int endIndex, int target) {
        int low = 0, high = endIndex;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (accDiff[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        Leetcode1208 l = new Leetcode1208();
        System.out.println(l.equalSubstring("abcd","bcdf",3));
    }
}
