package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode622 {
    class MyCircularQueue {
        List<Integer> l;
        int bigCount = 0;
        public MyCircularQueue(int k) {
            this.l = new ArrayList<>();
            this.bigCount = k;
        }

        public boolean enQueue(int value) {
            if (this.l.size() >= bigCount) {
                return false;
            }
            this.l.add(value);
            return true;
        }

        public boolean deQueue() {
            if (this.l.size() >=1) {
                this.l.remove(0);
                return true;
            }
            return false;
        }

        public int Front() {
            if (this.l.size() > 0) {
                return this.l.get(0);
            }
            return -1;
        }

        public int Rear() {
            if (this.l.size() > 0) {
                return this.l.get(this.l.size()-1);
            }
            return -1;
        }

        public boolean isEmpty() {
            return this.l.size() == 0;
        }

        public boolean isFull() {
            return this.l.size() == this.bigCount;
        }
    }
}
