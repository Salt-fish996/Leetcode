package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode933 {
    class RecentCounter {
        List<Integer> l = null;
        public RecentCounter() {
            this.l = new ArrayList<>();
        }

        public int ping(int t) {
            l.add(t);
            int count = 1;
            for (int i = l.size() -2;  i >= 0; i--) {
                if (l.get(i) >= t - 3000) {
                    count++;
                }
            }
            return count;
        }
    }
}
