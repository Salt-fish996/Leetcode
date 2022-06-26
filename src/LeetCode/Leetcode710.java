package src.LeetCode;

import java.util.*;

public class Leetcode710 {
    class Solution {

        int[] blackSet;
        int n;
        Random random;
        public Solution(int n, int[] blacklist) {
            this.n = n;
            this.blackSet = blacklist;
            Arrays.sort(this.blackSet);
            this.random = new Random();
        }

        public int pick() {
            int nextRandom = this.random.nextInt(this.n-this.blackSet.length);
            for (int i = 0; i < this.blackSet.length; i++) {
                if (this.blackSet[i] <= nextRandom) {
                    nextRandom++;
                } else {
                    break;
                }
            }
            return nextRandom;
        }
    }

}
