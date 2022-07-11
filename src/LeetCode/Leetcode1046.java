package src.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            queue.add(stones[i]);
        }
        int s1 = 0;
        int s2 = 0;
        while (queue.size() > 1) {
            s1 = queue.poll();
            s2 = queue.poll();
            if (s1 == s2) {
                continue;
            }
            queue.add(s1-s2);
        }
        return queue.size() >0 ? queue.poll():0;
    }
}
