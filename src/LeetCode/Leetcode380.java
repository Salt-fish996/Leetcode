package src.LeetCode;

import java.util.HashSet;

public class Leetcode380 {
    class RandomizedSet {

        HashSet<Integer> set = null;
        /** Initialize your data structure here. */
        public RandomizedSet() {

            set = new HashSet<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {

            if (set.contains(val)){
                return false;
            }else {
                set.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {

            if (set.contains(val)){
                return set.remove(val);
            }else {
                return false;
            }

        }

        /** Get a random element from the set. */
        public int getRandom() {

            int r = (int)(Math.random()*(set.size()-1));
            for (int d:set
                 ) {
                if (r-- == 0) return d;
            }
            return 0;
        }
    }
}
