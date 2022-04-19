package src.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode821 {
    public int[] shortestToChar(String s, char c) {
        // 遍历数组，获取字符c的所有位置
        Queue<Integer> q = new LinkedList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
           if (arr[i] == c)  {
              q.add(i);
           }
        }
        int before = Integer.MAX_VALUE;
        int next = Integer.MAX_VALUE;
        if (!q.isEmpty()) {
            before = q.poll();
        }
        if (!q.isEmpty()) {
            next = q.poll();
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int b = Math.abs(i-before);
            int n = Math.abs(i-next);
            if (b < n) {
                res[i] = b;
            } else if (b == n) {
                res[i] = b;
            } else {
                res[i] = n;
                before = next;
                next = Integer.MAX_VALUE;
                if (!q.isEmpty()) {
                    next = q.poll();
                }
            }
        }
        return res;
    }
}
