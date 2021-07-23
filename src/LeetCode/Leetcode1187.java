package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author hyy
 * @date 2020/3/24 9:11
 */
public class Leetcode1187 {
    public int makeArrayIncreasing1(int[] arr1, int[] arr2) {
        //将arr2排序
        Arrays.sort(arr2);
        //使用广度遍历，如果当前值比前面值小，那么一定要换，否则则可以换可以不换
        //记录arr1当前位置
        Queue<Integer> nowSitForArr1 = new LinkedList<>();
        //记录arr2当前位置
        Queue<Integer> nowSitForArr2 = new LinkedList<>();
        //记录arr1当前位置之前位置上的数
        Queue<Integer> preNum = new LinkedList<>();
        //记录操作次数
        Queue<Integer> count = new LinkedList<>();
        //初始化
        nowSitForArr1.add(0);
        nowSitForArr2.add(0);
        preNum.add(Integer.MIN_VALUE);
        count.add(0);

        int result = Integer.MAX_VALUE;
        while (!nowSitForArr1.isEmpty()) {
            int arr1Sit = nowSitForArr1.poll();
            int arr2Sit = nowSitForArr2.poll();
            int countTemp = count.poll();
            if (arr1Sit >= arr1.length) {
                result = Math.min(countTemp, result);
                continue;
            }

            int pre = preNum.poll();
            //如果arr1当前位置的数大于前一个数，那么可以改，可以不改
            if (arr1[arr1Sit] > pre) {
                nowSitForArr1.add(arr1Sit + 1);
                nowSitForArr2.add(arr2Sit);
                preNum.add(arr1[arr1Sit]);
                count.add(countTemp);
            }
            //修改位置上的数
            //从arr2中找到一个比pre大的数
            for (int i = arr2Sit; i < arr2.length; i++) {
                //贪心思想，找到最小的符合条件的数
                if (arr2[i] > pre) {
                    if (arr2[i] > arr1[arr1Sit] && arr1[arr1Sit] > pre) {
                        break;
                    }
                    nowSitForArr1.add(arr1Sit + 1);
                    preNum.add(arr2[i]);
                    nowSitForArr2.add(i);
                    count.add(countTemp + 1);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1:result;
    }

    //参考答案
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i: arr2)
            set.add(i);
        int[][] dp = new int[arr1.length][arr1.length + 1];
        dp[0][0] = arr1[0];
        dp[0][1] = set.first();
        for(int i = 1; i < arr1.length; ++i) {
            dp[i][0] = arr1[i] > dp[i - 1][0] && dp[i - 1][0] != Integer.MAX_VALUE ? arr1[i] : Integer.MAX_VALUE;
            for(int j = 1; j <= i; ++j) {
                dp[i][j] = set.higher(dp[i - 1][j - 1]) == null ? Integer.MAX_VALUE : set.higher(dp[i - 1][j - 1]);
                if(arr1[i] > dp[i - 1][j])
                    dp[i][j] = Math.min(dp[i][j], arr1[i]);
            }
            dp[i][i + 1] = set.higher(dp[i - 1][i]) == null ? Integer.MAX_VALUE : set.higher(dp[i - 1][i]);
        }
        for(int i = 0; i <= arr1.length; ++i)
            if(dp[arr1.length - 1][i] != Integer.MAX_VALUE)
                return i;
        return -1;
    }

}
