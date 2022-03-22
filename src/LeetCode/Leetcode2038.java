package src.LeetCode;

public class Leetcode2038 {
    public boolean winnerOfGame(String colors) {
        // 统计出A有多少，B有多少相连的
        int a = 0;
        int b = 0;
        int aCount = 0;
        int bCount = 0;
        char[] chars = colors.toCharArray();
        for (int i = 0; i < colors.length(); i++) {
            if (chars[i] == 'A') {
                if (aCount >= 2) {
                    a++;
                }
                aCount++;
                bCount = 0;
            } else {
                if (bCount >= 2) {
                    b++;
                }
                bCount++;
                aCount = 0;
            }
        }
        return a > 0 && (a-b >=0);
    }
}
