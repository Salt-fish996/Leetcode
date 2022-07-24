package src.LeetCode;

public class Leetcode1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        String[] max,min;
        if (s1.length < s2.length) {
            max = s2;
            min = s1;
            if (sentence2.startsWith(sentence1+" ") || sentence2.endsWith(" "+sentence1)) {
                return true;
            }
        } else {
            max = s1;
            min = s2;
            if (sentence1.startsWith(sentence2+" ") || sentence1.endsWith(" "+sentence2)) {
                return true;
            }
        }
        if (s1.length == s2.length) {
            return sentence1.equals(sentence2);
        }
        int hasNeedInsertIndex = -1;
        int minIndex = 0;
        boolean has = false;
        // 要不就是两头，要不就是一边
        for (int i = 0; i < max.length; i++) {
            if (minIndex < min.length && min[minIndex].equals(max[i])) {
                minIndex++;
                has = true;
                continue;
            } else {
                if (hasNeedInsertIndex == -1) {
                    hasNeedInsertIndex = i;
                } else if (i - hasNeedInsertIndex == 1) {
                    hasNeedInsertIndex +=1;
                } else {
                    return false;
                }
            }
        }
        return has && minIndex==min.length;
    }

    public static void main(String[] args) {
        Leetcode1813 l = new Leetcode1813();
        System.out.println(l.areSentencesSimilar("Aa AAaAaaAaaaAaAAaAA aaaAaAaAAaAaaAA","Aa AA"));
    }
}
