package LeetCode;

import java.util.Scanner;

public class Leetcode48 {
    public void rotate(int[][] matrix) {

        int[][] temp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][matrix[0].length-j-1] = temp[j][i];
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[][] m = new int[3][3];
        int count = 1;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = count++;
            }
        }
        Leetcode48 leetcode48 = new Leetcode48();
        leetcode48.rotate(m);

    }
}
