package src.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode73 {
    public void setZeroes(int[][] matrix) {

        //使用set来记录为0的点的横纵坐标
        Set<Integer> setX = new HashSet<>();
        Set<Integer> setY = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    setX.add(i);
                    setY.add(j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (setX.contains(i)){
                    matrix[i][j] = 0;
                }else if (setY.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
