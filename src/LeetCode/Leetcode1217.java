package src.LeetCode;

public class Leetcode1217 {
    public int minCostToMoveChips(int[] position) {
        int countOuShu = 0;
        int countJiShu = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                countOuShu++;
            } else {
                countJiShu++;
            }
        }
        return Math.min(countJiShu,countOuShu);
    }
}
