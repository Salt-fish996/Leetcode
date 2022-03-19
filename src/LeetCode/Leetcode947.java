package src.LeetCode;

import java.util.*;

public class Leetcode947 {
    Map<String,Integer> summaryMax = null;
    public int dpRemove(int[][] stones, Map<Integer, Integer> row, Map<Integer, Integer> col, Set<Integer> removeSet) {
        // 遍历如果row和col都是1，那么直接返回
        int max = 0;
        String key = Arrays.toString(removeSet.toArray());
        Integer t = summaryMax.get(key);
        if (t != null) {
            return t;
        }
        for (int i =0; i < stones.length; i++) {

            if (removeSet.contains(i)) {
                continue;
            }
            int k1 = stones[i][0];
            int r = row.get(k1);

            int k2 =stones[i][1];
            int c = col.get(k2);
            if (c < 2 && r < 2) {
                continue;
            }
            removeSet.add(i);
            row.put(k1,r-1);
            col.put(k2,c-1);
            max = Math.max(dpRemove(stones,row,col,removeSet)+1,max);
            row.put(k1,r);
            col.put(k2,c);
            removeSet.remove(i);
        }
        summaryMax.put(key,max);
        return max;
    }
    public int removeStones(int[][] stones) {
        // 使用一个 map 来统计每一行的点的数目，使用一个 map 来统计每一列的数目
        Map<Integer,Integer> row = new HashMap<>();
        Map<Integer,Integer> col = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        summaryMax = new HashMap<>();

        for (int i = 0; i < stones.length;i++) {
            int x = stones[i][0];
            int y = stones[i][1];
            row.put(x,row.getOrDefault(x,0)+1);
            col.put(y,col.getOrDefault(y,0)+1);
        }
       return this.dpRemove(stones,row,col,s);
    }

    public static void main(String[] args) {
        Leetcode947 l = new Leetcode947();
        int[][] a = new int[6][2];
        a[0] = new int[]{0,0};
        a[1] = new int[]{0,1};
        a[2] = new int[]{1,0};
        a[3] = new int[]{1,2};
        a[4] = new int[]{2,1};
        a[5] = new int[]{2,2};
        System.out.println(l.removeStones(a));
    }
}
