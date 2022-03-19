package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1711 {
    public int countPairs(int[] deliciousness) {
        final int MOD = 1000000007;
        Map<Integer,Integer> counts = new HashMap<>();
        int maxValue = 0;
        int pairs = 0;
        for (int value : deliciousness) {
            maxValue = Math.max(maxValue, value);
        }
        for (int k : deliciousness) {
            for (int j = 1; j <= maxValue * 2; j <<= 1) {
                int c = counts.getOrDefault(j - k, 0);
                pairs = (pairs + c) % MOD;
            }
            counts.put(k, counts.getOrDefault(k, 0) + 1);
        }
        return pairs;
    }

    public static void main(String[] args) {
        LeetCode1711 l = new LeetCode1711();
        System.out.println(l.countPairs(new int[]{1,3,7,5,9}));
    }
}
