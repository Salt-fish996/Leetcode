package src.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            List<Integer> l = map.getOrDefault(groupSizes[i],new ArrayList<>());
            l.add(i);
            map.put(groupSizes[i],l);
        }

        for (Map.Entry<Integer,List<Integer>> entry:map.entrySet()
             ) {
            int size = entry.getKey();
            List<Integer> v= entry.getValue();
            for (int i = 0; i < v.size() / size; i++) {
                List<Integer> s = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    s.add(v.get(i*size+j));
                }
                res.add(s);
            }
        }

        return res;
    }
}
