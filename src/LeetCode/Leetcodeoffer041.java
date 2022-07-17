package src.LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcodeoffer041 {
    class MovingAverage {

        Queue<Integer> q;
        int size;
        double sum;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.q = new ArrayDeque<>();
            this.size = size;
            this.sum = 0;
        }

        public double next(int val) {
            if (this.q.size() < this.size) {
                this.q.add(val);
                this.sum += val;
                return this.sum/this.q.size();
            }
            int t = q.poll();
            this.sum += val-t;
            q.add(val);
            return this.sum/size;
        }
    }
}
