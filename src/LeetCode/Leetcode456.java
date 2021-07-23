package LeetCode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

public class Leetcode456 {

    public boolean find132pattern(int[] nums) {


        //用stack存储从右到左最大值
        //用second存储次大值
        //如果当前元素大于first中的值，那么first取出最放入second中
        //如果当前元素小于first和second，返回true
        if (nums.length < 3)
            return false;

        int second = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        stack.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {

            if (nums[i] < second) {
                return true;
            } else {
                while (!stack.isEmpty() && nums[i] > stack.peek()) {
                    second = Math.max(stack.pop(), second);
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
