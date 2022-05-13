package src.LeetCode;

public class Leetcodemianshi0105 {
    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length() && first.equals(second)) {
            return true;
        }
        if (first.length() > second.length()) {
            String t = first;
            first = second;
            second = t;
        }
        if (first.length() < second.length()-1) {
            return false;
        }
        char[] a1 = first.toCharArray();
        char[] a2 = second.toCharArray();
        // 保证a1.length<=a2.length
        int count = 0;
        if (a1.length == a2.length) {
            for (int i = 0; i < a1.length; i++) {
                if (a1[i] != a2[i]) {
                    count++;
                    if (count > 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[count]) {
                if (i == count) {
                    count++;
                    if (a1[i] != a2[count]) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            count++;
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcodemianshi0105 l = new Leetcodemianshi0105();
        System.out.println(l.oneEditAway("pale","ple"));
    }
}
