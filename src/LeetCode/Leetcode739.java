package src.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i+1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Leetcode739 l = new Leetcode739();
        System.out.println(Arrays.toString(l.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }


}
