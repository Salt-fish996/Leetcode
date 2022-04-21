package src.LeetCode;

import java.math.BigInteger;
import java.util.Arrays;

public class Leetcode2187 {
    public long minimumTime(int[] time, int totalTrips) {
        // 升序排序
        Arrays.sort(time);
        System.out.println(time.length);
        // 计算出需要运行的最长时间
        long maxLongTime = (long)time[0]*(long)totalTrips;
        // 使用二分查找，计算在固定时间内能够完成的次数
        long minLongTime = 0;
        while (true) {
            long mid = (maxLongTime+minLongTime) / 2;
            if (maxLongTime- minLongTime <= 1) {
                return maxLongTime;
            }
            int e = calTrips(time,mid,totalTrips);
            if (e == 0) {
               if (calTrips(time,mid-1,totalTrips) == -1) {
                   return mid;
               }
               maxLongTime = mid;
            }else if (e == -1) {
                minLongTime = mid;
            } else {
                maxLongTime = mid;
            }
        }
    }   
    public int calTrips(int[] time, long t,int totalTips) {
        int sum = 0;
        for (int j : time) {
            sum += t / j;
            if (sum > totalTips) {
                return 1;
            }
        }
        return sum == totalTips?0:-1;
    }

    public static void main(String[] args) {
        Leetcode2187 l = new Leetcode2187();
        int[] t = new int[ 100000];
        Arrays.fill(t, 1);
        System.out.println(l.minimumTime(t,10000000));
    }
}
