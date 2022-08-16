package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Leetcode1656 {
    class OrderedStream {
        String[] arr;
        int p;
        public OrderedStream(int n) {
            this.arr = new String[n+1];
            this.p = 1;
        }

        public List<String> insert(int idKey, String value) {
            this.arr[idKey] = value;
            List<String> res = new ArrayList<>();
            if (this.p < this.arr.length && !Objects.equals(this.arr[this.p], "")) {
                for (int i=this.p; i < this.arr.length; i++) {
                    String t = this.arr[i];
                    if (Objects.equals(t, "")) {
                        this.p = i;
                        return res;
                    }
                    res.add(t);
                }
                this.p = this.arr.length;
                return res;
            }
            return res;
        }
    }
}
