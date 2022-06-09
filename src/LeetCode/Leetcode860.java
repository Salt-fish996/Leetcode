package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode860 {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
                if (bills[i] == 20) {
                    int c10 = count.getOrDefault(10,0);
                    int c5 = count.getOrDefault(5,0);
                    if (c10 == 0) {
                        if (c5 < 3) {
                            return false;
                        }
                        count.put(5,c5-3);
                    } else {
                        if (c5 < 1) {
                            return false;
                        }
                        count.put(10,c10-1);
                        count.put(5,c5-1);
                    }
                } else if (bills[i] == 10) {
                    int c5 = count.getOrDefault(5,0);
                    if (c5 < 1) {
                        return false;
                    }
                    count.put(5,c5-1);
                }
            count.put(bills[i], count.getOrDefault(bills[i],0)+1);
        }
        return true;
    }
}
