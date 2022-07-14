package src.LeetCode;

public class Leetcode735 {
    public int[] asteroidCollision(int[] asteroids) {
        int[] status = new int[asteroids.length];
        int count =0;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] <0) {
                // 向左
                for (int j = i-1; j >= 0; j--) {
                    if (status[j] == 1 || asteroids[j] < 0) {
                        continue;
                    }
                    if (-1*asteroids[i] > asteroids[j]) {
                       status[j] = 1;
                       count++;
                    } else if (-1*asteroids[i] == asteroids[j]) {
                        status[j] = 1;
                        status[i] = 1;
                        count += 2;
                        break;
                    } else {
                        status[i] = 1;
                        count++;
                        break;
                    }
                }
            }
        }
        int[] res = new int[asteroids.length-count];
        int index = 0;
        for (int i = 0; i < status.length; i++) {
            if (status[i] == 0) {
                res[index++] = asteroids[i];
            }
        }
        return res;
    }
}
