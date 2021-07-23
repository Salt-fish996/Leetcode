package LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2020/3/20 12:53
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 *
 * 选取一个删除索引序列，对于 A 中的每个字符串，删除对应每个索引处的字符。
 *
 * 比如，有 A = ["babca","bbazb"]，删除索引序列 {0, 1, 4}，删除后 A 为["bc","az"]。
 *
 * 假设，我们选择了一组删除索引 D，那么在执行删除操作之后，最终得到的数组的行中的每个元素都是按字典序排列的。
 *
 * 清楚起见，A[0] 是按字典序排列的（即，A[0][0] <= A[0][1] <= ... <= A[0][A[0].length - 1]），A[1] 是按字典序排列的（即，A[1][0] <= A[1][1] <= ... <= A[1][A[1].length - 1]），依此类推。
 *
 * 请你返回 D.length 的最小可能值。
 */
public class Leetcode960 {
    //超时
//    static int min = Integer.MAX_VALUE;
//    //对于每一个位置都可以选择删除或者不删除，因此可以采用dfs
//    public void dfs(String[] s, int now, int pre, int removes) {
//        //剪枝
//        if (removes >= min) {
//            return;
//        }
//        //递归出口
//        if (now == s[0].length()) {
//            min = Math.min(min, removes);
//            return;
//        }
//        //保证now前面的每个字符都是递增的
//        for (int i = 0; i < s.length; i++) {
//            char[] temp = s[i].toCharArray();
//            if (pre != -1 && temp[pre] > temp[now]) {
//                dfs(s, now + 1, pre, removes + 1);
//                return;
//            }
//        }
//        dfs(s, now + 1, pre, removes + 1);
//        dfs(s, now + 1, now, removes);
//    }
//    //使用深度遍历
//    public int minDeletionSize(String[] A) {
//        min = Integer.MAX_VALUE;
//        dfs(A, 0,-1,0);
//
//        return min;
//    }

    //参考答案
    public int minDeletionSize(String[] A) {
        int W = A[0].length();
        int[] dp = new int[W];
        Arrays.fill(dp, 1);
        for (int i = W-2; i >= 0; --i)
            search: for (int j = i+1; j < W; ++j) {
                for (String row: A)
                    if (row.charAt(i) > row.charAt(j))
                        continue search;

                dp[i] = Math.max(dp[i], 1 + dp[j]);
            }

        int kept = 0;
        for (int x: dp)
            kept = Math.max(kept, x);
        return W - kept;
    }

    public void testHashMap() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, i);
        }
        System.out.println("未初始化时间：" + (System.currentTimeMillis() - start));
        HashMap<Integer, Integer> hashMap1 = new HashMap<>(1000000);
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            hashMap.put(i, i);
        }
        System.out.println("初始化时间：" + (System.currentTimeMillis() - start));

    }

    public void testArrayList() {
        List<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        System.out.println("未初始化时间：" + (System.currentTimeMillis() - start));
        List<Integer> list1 = new ArrayList<>(1500000);
        start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list1.add(i);
        }
        System.out.println("初始化时间：" + (System.currentTimeMillis() - start));
    }
    public static void main(String[] args) {
        Leetcode960 leetcode960 = new Leetcode960();
        System.out.println(leetcode960.minDeletionSize(new String[]{"aaaabaa"}));
        leetcode960.testHashMap();
        leetcode960.testArrayList();

    }
}
