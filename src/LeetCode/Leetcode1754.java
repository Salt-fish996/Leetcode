package src.LeetCode;

public class Leetcode1754 {
    public String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length() && word1.substring(i).compareTo(word2.substring(j)) > 0) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }
        return merge.toString();
    }


    public static void main(String[] args) {
        Leetcode1754 l = new Leetcode1754();
        System.out.println(l.largestMerge("cabaa","bcaaa"));
    }

}
