package ByteDance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author hyy
 * @date 2020/3/15 18:59
 */
//62.5%
public class Three {
    static int steps = Integer.MAX_VALUE;

    //使用深度遍历
    public void dfs(int[][] grid, int row, int col,int nowStep, int[][] status, HashMap<Integer, Set<Point>> hashMap,Point begin, Point end) {
        //如果当前已经走到了终点，那么计算走过的步数
        if (row == end.row && col == end.col) {
            steps = Math.min(nowStep, steps);
            return;
        }
        //如果当前的步数大于已经计算出的步数，那么返回
        if (nowStep >= steps) {
            return;
        }
        //如果是在传送门上，那么可以传送也可以不传送,不传送的话和普通点一样
        if (grid[row][col] != -2 && grid[row][col] != -3 && grid[row][col] != 0) {
            //找到传送点
            Set<Point> points = hashMap.get(grid[row][col]);
            Point temp = null;
            for (Point p :points
                    ) {
                if (p.row != row || p.col != col) {
                    temp = p;
                    break;
                }
            }

            if (temp != null && status[temp.row][temp.col] != 1 && grid[temp.row][temp.col] != -1) {
                //设置当前点已经访问过
                status[temp.row][temp.col] = 1;
                dfs(grid,temp.row, temp.col, nowStep + 1,status,hashMap, begin, end);
                status[temp.row][temp.col] = 0;
            }
           }

        //在不传送情况下，只能向四个方向走
        //向左
        if (col - 1 >= 0 && status[row][col - 1] != 1 && grid[row][col - 1] != -1) {
            status[row][col - 1] = 1;
            dfs(grid,row, col - 1, nowStep + 1,status,hashMap, begin, end);
            status[row][col - 1] = 0;
        }
        //向右
        if (col + 1 < grid[0].length && status[row][col + 1] != 1 && grid[row][col + 1] != -1) {
            status[row][col + 1] = 1;
            dfs(grid,row, col + 1, nowStep + 1,status,hashMap, begin, end);
            status[row][col + 1] = 0;
        }
        //向上
        if (row - 1 >= 0 && status[row - 1][col] != 1 && grid[row - 1][col] != -1) {
            status[row - 1][col] = 1;
            dfs(grid,row - 1, col, nowStep + 1,status,hashMap, begin, end);
            status[row - 1][col] = 0;
        }
        //向下
        if (row +1 < grid.length && status[row + 1][col] != 1 && grid[row + 1][col] != -1) {
            status[row + 1][col] = 1;
            dfs(grid,row + 1, col, nowStep + 1,status,hashMap, begin, end);
            status[row + 1][col] = 0;
        }


    }
    static class Point{
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public Point(){};
        public int row;
        public int col;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //记录终点和起点的位置
        Point begin = new Point();
        Point end = new Point();
        int col = in.nextInt();
        int row = in.nextInt();
        int[][] grid = new int[row][col];
        //使用hashMap存储传送门
        HashMap<Integer, Set<Point>> hashMap = new HashMap<>();
        //读取并初始化数据
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = in.nextInt();
                if (grid[i][j] == -2) {
                    begin.col = j;
                    begin.row = i;
                } else if (grid[i][j] == -3) {
                    end.row = i;
                    end.col = j;
                } else if (grid[i][j] != -1 && grid[i][j] != 0){
                    Point point = new Point(i, j);
                    if (hashMap.containsKey(grid[i][j])) {
                        Set<Point> points = hashMap.get(grid[i][j]);
                        points.add(point);
                        hashMap.put(grid[i][j], points);
                    } else {
                        Set<Point> set = new HashSet<>();
                        set.add(point);
                        hashMap.put(grid[i][j], set);
                    }
                }
            }
        }

        //进行计算
        steps = Integer.MAX_VALUE;
        int[][] status = new int[row][col];
        status[begin.row][begin.col] = 1;
        Three three = new Three();
        three.dfs(grid, begin.row, begin.col, 0,status,hashMap,begin,end);
        if (steps != Integer.MAX_VALUE) {
            System.out.println(steps);
        } else {
            System.out.println(-1);
        }

    }
}
