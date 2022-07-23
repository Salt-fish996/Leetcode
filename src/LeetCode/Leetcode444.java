package src.LeetCode;

import java.util.*;

public class Leetcode444 {
    // 超时
    public boolean sequenceReconstruction1(int[] nums, int[][] sequences) {

        // 拓扑排序
        Set<Integer>[] sets = new Set[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            sets[i] = new HashSet<Integer>();
        }
        for (int i = 0; i <sequences.length; i++) {
            for (int j = 1; j < sequences[i].length; j++) {
                sets[sequences[i][j]].add(sequences[i][j-1]);
            }
        }
        int[] status = new int[nums.length+1];

        int count = 0;
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < sets.length; i++) {
            Set<Integer> s = sets[i];
            if (s.size() == 0) {
                status[i] = 1;
                q.add(i);
                count++;
            }
        }

        if (q.size() > 1) {
            return false;
        }

        while (!q.isEmpty()) {
            int s = q.poll();
            for (int i = 1; i < sets.length; i++) {
                sets[i].remove(s);
                if (status[i] == 0 && sets[i].size() == 0) {
                    q.add(i);
                    count++;
                    status[i]=1;
                }
            }
            if (q.size() > 1) {
                return false;
            }
        }
        if (count < nums.length) {
            return false;
        }
        return true;
    }

    // 参考答案
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] indegrees = new int[n + 1];
        Set<Integer>[] graph = new Set[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<Integer>();
        }
        for (int[] sequence : sequences) {
            int size = sequence.length;
            for (int i = 1; i < size; i++) {
                int prev = sequence[i - 1], next = sequence[i];
                if (graph[prev].add(next)) {
                    indegrees[next]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int num = queue.poll();
            Set<Integer> set = graph[num];
            for (int next : set) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "[[5,2,6,3],[4,1,5,2]]";
        String[] ss = s.split("],");
        int row = ss.length;
        int col = ss[0].split(",").length;
        int[][] grid = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] sss = ss[i].replace("[", "").replace("]", "").split(",");
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(sss[j]);
            }
        }
        Leetcode444 l = new Leetcode444();
        System.out.println(l.sequenceReconstruction(new int[]{4,1,5,2,6,3},grid));
    }
}
