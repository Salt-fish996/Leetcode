package LeetCode;

import java.util.Arrays;

public class Leetcode455 {
    public int findContentChildren(int[] g, int[] s) {

        //将孩子需要的饼干排序
        Arrays.sort(g);
        //将饼干尺寸进行排序
        Arrays.sort(s);

        //贪心算法，从最小的饼干进行分配，如果当前饼干已经不能满足了，那么就取下一个饼干进行分配
        int gCount = 0;
        int sCount = 0;
        int count = 0;
        while (sCount < s.length &&gCount< s.length){//如果当前饼干尺寸满足孩子要求，那么就分给孩子
            if (g[gCount] <= s[sCount]){
                count++;
                gCount++;
                sCount++;
            }else{//如果当前的饼干尺寸不满足，那么取下一个饼干
                sCount++;
            }
        }

        return count;
    }
}
