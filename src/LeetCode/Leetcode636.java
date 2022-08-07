package src.LeetCode;

import java.util.*;

public class Leetcode636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        // 使用栈来模拟
        Stack<String> startTime = new Stack<>();
        Stack<Integer> count = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < logs.size(); i++) {
            String[] s = logs.get(i).split(":");
            if (Objects.equals(s[1], "start")) {
                startTime.add(s[2]);
                count.add(0);
            }else {
                int st = Integer.parseInt(startTime.pop());
                int index = Integer.parseInt(s[0]);
                int et = Integer.parseInt(s[2]);
                int t = count.size() >0 ?count.pop():0;
                res[index] += et-st-t+1;
                t = startTime.size() > 0 ?et-st+1:0;
               if (startTime.size() == 0) {
                   continue;
               }
                while (count.size() >= startTime.size()) {
                   t += count.pop();
                }
                count.add(t);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode636 l = new Leetcode636();
        String[] s = new String[]{"0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"};
        List<String> ss = new ArrayList<>();
        Collections.addAll(ss, s);
        System.out.println(Arrays.toString(l.exclusiveTime(2, ss)));
    }
}
