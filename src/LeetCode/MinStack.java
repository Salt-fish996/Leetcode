package src.LeetCode;

import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author hyy
 * @date 2020/3/19 12:16
 */
class MinStack {
    private Stack<Integer> stack = null;
    TreeMap<Integer, Integer> treeMap = null;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        treeMap = new TreeMap<>();
    }

    public void push(int x) {
        treeMap.put(x, treeMap.getOrDefault(x, 0) + 1);
        stack.push(x);

    }

    public void pop() {
        Integer pop = stack.pop();
        Integer integer = treeMap.get(pop);
        if (integer == 1) {
            treeMap.remove(pop);
        } else {
            treeMap.put(pop, integer - 1);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return treeMap.firstKey();
    }
}
