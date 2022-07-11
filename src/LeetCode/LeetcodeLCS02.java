package src.LeetCode;


import java.util.*;

public class LeetcodeLCS02 {
    public int halfQuestions(int[] questions) {
        // 统计题目的数目
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < questions.length; i++) {
            map.put(questions[i],map.getOrDefault(questions[i],0)+1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
               return o2-o1;
            }
        });
        for (Map.Entry<Integer,Integer> entry:map.entrySet()
             ) {
            q.add(entry.getValue());
        }
        int count = questions.length/2;
        int res=0;
        while (count > 0) {
            res++;
            count -= q.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        LeetcodeLCS02 l = new LeetcodeLCS02();
        System.out.println(l.halfQuestions(new int[]{2,1,6,2}));
    }
}
