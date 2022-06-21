package src.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcodemianshi0303 {
    class StackOfPlates {
        int cap = 0;
        int index = 0;
        List<Stack<Integer>> list;
        public StackOfPlates(int cap) {
            this.list = new ArrayList<>();
            this.cap = cap;
        }

        public void push(int val) {
            if (this.list.size() > 0) {
                if (this.list.get(index).size() < this.cap) {
                    this.list.get(index).push(val);
                } else {
                    index++;
                    Stack<Integer> stack = new Stack<>();
                    stack.push(val);
                    this.list.add(stack);
                }
            }else if (cap>0){
                index=0;
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                this.list.add(stack);
            }
        }

        public int pop() {
            if (this.list.size() <= 0) {
                return -1;
            }
            int res;
            Stack<Integer> s = this.list.get(this.list.size() - 1);
            res = s.pop();
            if (s.size() == 0) {
                this.list.remove(this.list.size() - 1);
                index--;
            }
            return res;
        }

        public int popAt(int index) {
            if (this.list.size() <= index) {
                return -1;
            }
            int res = this.list.get(index).pop();
            if (this.list.get(index).size() == 0) {
                this.list.remove(index);
                this.index--;
            }
            return res;
        }
    }
}
