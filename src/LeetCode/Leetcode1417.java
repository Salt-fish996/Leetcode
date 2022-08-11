package src.LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode1417 {
    public String reformat(String s) {
        Queue<Character> nums = new ArrayDeque<>();
        Queue<Character> characters = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                nums.add(s.charAt(i));
            } else {
                characters.add(s.charAt(i));
            }
        }
        if (Math.abs(nums.size() - characters.size()) > 1) {
            return "";
        }
        Queue<Character> max = nums.size() >= characters.size() ? nums:characters;
        Queue<Character> min = nums.size() >= characters.size() ? characters:nums;
        StringBuilder res = new StringBuilder();
        while (!min.isEmpty()) {
            res.append(max.poll());
            res.append(min.poll());
        }
        while (!max.isEmpty()) {
            res.append(max.poll());
        }
        return res.toString();
    }
}
