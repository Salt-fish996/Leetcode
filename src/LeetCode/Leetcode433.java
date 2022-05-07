package src.LeetCode;

import java.util.*;

public class Leetcode433 {
    // 暴力dfs，时间复杂度较高，参考答案可使用广度遍历
    String[] s = new String[]{"A", "C", "G", "T"};
    int min = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        int res = dfs(start,end,0,new int[bank.length],bank);
        return res==Integer.MAX_VALUE?-1:res;
    }

    int dfs(String start, String end, int count, int[] status,String[] bank) {
        if (Objects.equals(end, start)) {
            min = Math.min(min,count);
            return count;
        }
        if (count > min) {
            return Integer.MAX_VALUE;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < start.length(); i++) {
            String prefix = i>0?start.substring(0,i):"";
            String suffix = i<start.length()-1?start.substring(i+1):"";
            for (int j = 0; j < 4; j++) {
                String temp = prefix+s[j]+suffix;
                if (!temp.equals(start)) {
                    for (int k = 0; k < bank.length; k++) {
                        if (status[k] == 0 && temp.equals(bank[k])) {
                            status[k] = 1;
                            res = Math.min(res,dfs(temp,end,count+1,status,bank));
                            status[k]=0;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcode433 l = new Leetcode433();
        System.out.println(l.minMutation("AAAAACCC","AACCCCCC",new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
    }
}
