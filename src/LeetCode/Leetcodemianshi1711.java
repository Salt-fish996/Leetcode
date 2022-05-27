package src.LeetCode;

public class Leetcodemianshi1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int res = Integer.MAX_VALUE;
        boolean nextIsOne = true;
        while (true) {
            if (nextIsOne ) {
                while (index1 <= words.length-1) {
                    index1++;
                    if (index1 < words.length -1 && words[index1].equals(word1)) {
                        if (index2 != -1 && index2 != words.length) {
                            res = Math.min(Math.abs(index1-index2),res);
                        }
                        break;
                    }
                }
                nextIsOne = index1 < index2;
            } else {
                while (index2 <= words.length-1) {
                    index2++;
                    if (index2 < words.length -1 && words[index2].equals(word2)) {
                        if (index1 != words.length) {
                            res = Math.min(Math.abs(index1-index2),res);
                        }
                        break;
                    }
                }
                nextIsOne = index1 < index2;
            }

            if (index1 == index2 && index1 == words.length) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Leetcodemianshi1711 l = new Leetcodemianshi1711();
        System.out.println(l.findClosest(new String[]{"I","am","a","student","from","a","university","in","a","city"},"a","student"));
    }
}
