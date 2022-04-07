package src.LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

public class Leetcode295 {
    class MedianFinder {
        ArrayList<Integer> l = new ArrayList<>();
        int count = 0;
        TreeSet<Integer> s = new TreeSet<>();
        // 减少排序次数，保证每个状态只会排序一次
        boolean sorted = true;
        public MedianFinder() {
        }

        public void addNum(int num) {
            this.l.add(num);
            this.count++;
            this.sorted = false;
        }

        public double findMedian() {
            if (!this.sorted) {
                this.sorted = true;
                l.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
            }
            if (count % 2 == 0) {
                return (double)(this.l.get(count / 2 - 1)+ this.l.get(count/2))/2;
            }
            return this.l.get(count/2);
        }
    }
}
