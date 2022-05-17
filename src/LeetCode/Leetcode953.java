package src.LeetCode;

public class Leetcode953 {
    public boolean isAlienSorted(String[] words, String order) {

        for (int i = 0; i < words.length-1; i++) {
            if (!compare(words[i],words[i+1],order)) {
                return false;
            }
        }
        return true;
    }

    public boolean compare(String f,String s,String order) {
        int max = Math.min(f.length(), s.length());
        for (int i = 0; i < max; i++) {
            int indexOf = order.indexOf(f.charAt(i));
            int of = order.indexOf(s.charAt(i));
            if (indexOf > of) {
                return false;
            } else if (indexOf < of) {
                return true;
            }
        }
        if (f.length() > s.length()) {
            return false;
        }
        return true;
    }
}
