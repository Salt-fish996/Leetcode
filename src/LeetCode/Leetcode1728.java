package src.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1728 {
    // 未解答出
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        char[][] grids = new char[grid.length][grid[0].length()];
        int fx,fy;
        Set<Integer> mxs = new HashSet<>();
        Set<Integer> mys = new HashSet<>();
        Set<Integer> cxs = new HashSet<>();
        Set<Integer> cys = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            grids[i] = grid[i].toCharArray();
            for (int j = 0; j < grids[i].length; j++) {
                if (grids[i][j] == 'C') {
                    cxs.add(i);
                    cys.add(j);
                } else if (grids[i][j] == 'M') {
                    mxs.add(i);
                    mys.add(j);
                } else if (grids[i][j] == 'F') {
                    fx = i;
                    fy = j;
                }
            }
        }

    return true;
    }

    // mx,my表示老鼠在的位置，cx,xy表示猫在的位置,count表示老鼠走过的次数，fx,fy表示食物所在的位置
    public boolean dfs(char[][] grid,int mx,int my,int cx,int cy,int count,int fx,int fy,boolean nextIsMouse,int catJump,int mouseJump) {
        if (mx == cx && my == cy) {
            return false;
        }
        if (cx == fx && cy == fy) {
            return true;
        }
        if (mx == fx && my == fy) {
            return false;
        }
        if (count > 1000) {
            return false;
        }
        if (!nextIsMouse) {
            // 猫只需要往食物
        }
        if (nextIsMouse) {
            for (int i = 0; i < mouseJump; i++) {

            }
        }
        return false;

    }
}
