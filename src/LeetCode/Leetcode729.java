package src.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode729 {
    class MyCalendar {
        List<Integer> starts;
        List<Integer> ends;
        int n= 0;
        public MyCalendar() {
            starts = new ArrayList<>();
            ends = new ArrayList<>();
            n = 0;
        }

        public boolean book(int start, int end) {

            for (int i = 0; i < n; i++) {
                int s = this.starts.get(i);
                int e = this.ends.get(i);
               if (!(s >= end || start >= e)) {
                   return false;
               }
            }
                this.starts.add(start);
                n++;
                this.ends.add(end);
                return true;
        }
    }

}
