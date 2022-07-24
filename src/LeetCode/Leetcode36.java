package src.LeetCode;

import java.util.HashSet;
import java.util.Set;

//验证数独是否有效,通过
public class Leetcode36 {
    public boolean isValidSudoku(char[][] board) {

        int m = board.length;
        int n = board[0].length;
        Set<Character> set = new HashSet<>();//用于存储已经用过的数字
        //首先验证行
        for (int i = 0; i < m; i++) {
            set.clear();
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (set.contains(c)){
                    return false;
                }
                if (c>='1' && c<='9')
                set.add(c);
            }
        }
        //验证列
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = 0; j < m; j++) {
                char c = board[j][i];
                if (set.contains(c)){
                    return false;
                }
                if (c>='1' && c<='9')
                set.add(c);
            }
        }

        //验证九宫格
        int mCount = m/3;
        int nCount = n/3;
        for (int i = 0; i < mCount; i++) {
            for (int j = 0; j < nCount; j++) {
                set.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char c = board[i*3 + k][j*3 + l];
                        if (set.contains(c)){
                            return false;
                        }
                        if (c>='1' && c<='9')
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }
}
