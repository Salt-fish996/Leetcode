package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode641 {
    class MyCircularDeque {
        int max;
        List<Integer> list;
        public MyCircularDeque(int k) {
            this.list = new ArrayList<>();
            this.max = k;
        }

        public boolean insertFront(int value) {
            if (this.list.size() == this.max) {
                return false;
            }
            List<Integer> l = new ArrayList<>();
            l.add(value);
            l.addAll(this.list);
            this.list = l;
            return true;
        }

        public boolean insertLast(int value) {
            if (this.list.size() == this.max) {
                return false;
            }
            this.list.add(value);
            return true;
        }

        public boolean deleteFront() {
            if (this.list.size() == 0) {
                return false;
            }
            this.list.remove(0);
            return true;
        }

        public boolean deleteLast() {
            if (this.list.size() == 0) {
                return false;
            }
            this.list.remove(this.list.size()-1);
            return true;
        }

        public int getFront() {
            if (this.list.size() == 0) {
                return -1;
            }
            return this.list.get(0);
        }

        public int getRear() {
            if (this.list.size() == 0) {
                return -1;
            }
            return this.list.get(this.list.size()-1);
        }

        public boolean isEmpty() {
            return this.list.size() == 0;
        }

        public boolean isFull() {
            return this.list.size() == this.max;
        }
    }
}
