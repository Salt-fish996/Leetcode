package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcodeoffer35 {
    public int findMinDifference(List<String> timePoints) {
        String[] ss = new String[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            ss[i] = timePoints.get(i);
        }
        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for (int i = 0; i < 5; i++) {
                    if (o1.charAt(i) == o2.charAt(i)) {
                        continue;
                    }
                    return o1.charAt(i)-o2.charAt(i);
                }
                return 0;
            }
        });
        int c = Integer.MAX_VALUE;
        for (int i = 1; i < ss.length; i++) {
            c = Math.min(c,cal(ss[i-1],ss[i]));
        }
        c = Math.min(c,cal(ss[0],ss[ss.length-1]));
        return c;
    }

    public int cal(String s1,String s2) {
        int n = s2.charAt(0)-s1.charAt(0);
        n = n*10+ s2.charAt(1)-s1.charAt(1);
        n = n*60+(s2.charAt(3)-s1.charAt(3))*10+s2.charAt(4)-s1.charAt(4);
        if (n > 12*60) {
            n = 24*60-n;
        }
        return n;
    }

    public static void main(String[] args) {
        Leetcodeoffer35 l = new Leetcodeoffer35();
        List<String> ll = new ArrayList<>();
        ll.add("05:47");
        ll.add("06:24");
        ll.add("19:05");
        ll.add("19:47");
        ll.add("19:46");
        System.out.println(l.findMinDifference(ll));
    }
}
