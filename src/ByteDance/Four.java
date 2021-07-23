package ByteDance;

import java.util.Scanner;

/**
 * @author hyy
 * @date 2020/3/15 18:59
 */
//未通过，可以通过dfs检查两个点能不能通过3个线段进行连接
public class Four {
    public boolean check(int x1, int y1 ,int x2, int y2, char[][] grid) {
        if (grid[x1][y1] == grid[x2][y2]) {
            grid[x1][y1] = '.';
            grid[x2][y2] = '.';
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Four four = new Four();
        Scanner in = new Scanner(System.in);
        String[] temp = in.nextLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);
        char[][] strings = new char[n][m];
        for (int i = 0; i < n; i++) {
            strings[i] = in.nextLine().toCharArray();
        }
        int q = Integer.parseInt(in.nextLine());
        int[][] oper = new int[q][4];
        for (int i = 0; i < q; i++) {
            String[] s = in.nextLine().split(" ");
            for (int j = 0; j <4; j++) {
                oper[i][j] = Integer.parseInt(s[j]);
            }
            if (four.check(oper[i][0],oper[i][1],oper[i][2],oper[i][3],strings)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
