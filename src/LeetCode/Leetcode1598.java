package src.LeetCode;

import java.util.Objects;

public class Leetcode1598 {
    public int minOperations(String[] logs) {
        int res = 0;
        for (int i=0; i < logs.length; i++) {
            if (Objects.equals(logs[i], "./")) {
                continue;
            }
            if (Objects.equals(logs[i], "../")) {
                if (res > 0) {
                    res -=1;
                }
                continue;
            }
            res++;
        }
        return res;
    }
}
