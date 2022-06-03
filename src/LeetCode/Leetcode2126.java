package src.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class Leetcode2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int[] status = new int[asteroids.length];
        int sum;
        long total = mass;
        int count = 0;
        int c;
        int max = asteroids[0];
        for (int i = 0; i < asteroids.length; i++) {
            max = Math.max(max,asteroids[i]);
        }
        while (count < asteroids.length) {
            sum = 0;
            c = 0;
            for (int i = 0; i < asteroids.length; i++) {
                if (status[i] == 1) {
                    continue;
                }
                if (asteroids[i] <= total) {
                    sum += asteroids[i];
                    if (sum > max) {
                        return true;
                    }
                    count++;
                    status[i] = 1;
                    c++;
                }
            }
            if (c == 0) {
                return false;
            }
            total += sum;
            if (total > max) {
                return true;
            }
        }
      return true;
    }
}
