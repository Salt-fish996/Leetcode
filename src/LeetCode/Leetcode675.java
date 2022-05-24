package src.LeetCode;

import java.util.*;

public class Leetcode675 {
    public int cutOffTree(List<List<Integer>> forest) {
        Map<Integer,Integer>  sitx = new HashMap<>();
        Map<Integer,Integer> sity = new HashMap<>();
        TreeSet<Integer> q = new TreeSet<>();
        int m = forest.size();
        int n = forest.get(0).size();
        int[][] position = new int[forest.size()][forest.get(0).size()];
        for (int i = 0; i < forest.size(); i++) {
            List<Integer> l = forest.get(i);
            for (int j = 0; j < l.size(); j++) {
                int h = l.get(j);
                sitx.put(h,i);
                sity.put(h,j);
                position[i][j] = h;
                if (h > 1) {

                    q.add(h);
                }
            }
        }

        int res = 0;
        Queue<Integer> q2x = new LinkedList<>();
        Queue<Integer> q2y = new LinkedList<>();
        q2x.add(0);
        q2y.add(0);

        Queue<Integer> qq = new LinkedList<>();
        qq.add(0);
        while (!q.isEmpty()) {
            int next = q.first();
            q.remove(next);
            int count = 0;
            int[][] status =new int[forest.size()][forest.get(0).size()];
            while (!q2x.isEmpty()) {
                int x = q2x.poll();
                int y = q2y.poll();
                int c = qq.poll();
                status[x][y] = 1;
                if (x == sitx.get(next) && y == sity.get(next)) {
                    res += c;
                    q2x.clear();
                    q2y.clear();
                    q2x.add(x);
                    q2y.add(y);
                    qq.clear();
                    qq.add(0);
                    break;
                }

                if (x+1 < m && position[x+1][y]!=0 && status[x+1][y] == 0) {
                    q2x.add(x+1);
                    q2y.add(y);
                    status[x+1][y] = 1;
                    qq.add(c+1);
                }

                if (x -1 >= 0 && position[x-1][y] != 0 && status[x-1][y] == 0) {
                    q2x.add(x-1);
                    q2y.add(y);
                    status[x-1][y] = 1;
                    qq.add(c+1);
                }

                if (y+1 < n && position[x][y+1] != 0 && status[x][y+1] == 0) {
                    q2x.add(x);
                    q2y.add(y+1);
                    status[x][y+1] = 1;
                    qq.add(c+1);
                }
                if (y - 1 >= 0 && position[x][y-1] != 0 && status[x][y-1] == 0) {
                    q2x.add(x);
                    q2y.add(y-1);
                    status[x][y-1] = 1;
                    qq.add(c+1);
                }

            }
            if (q2x.size() == 0) {
                return -1;
            }
        }
        return res;
    }

    // 参考答案
    class Solution {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int cutOffTree(List<List<Integer>> forest) {
            List<int[]> trees = new ArrayList<int[]>();
            int row = forest.size();
            int col = forest.get(0).size();
            for (int i = 0; i < row; ++i) {
                for (int j = 0; j < col; ++j) {
                    if (forest.get(i).get(j) > 1) {
                        trees.add(new int[]{i, j});
                    }
                }
            }
            Collections.sort(trees, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));

            int cx = 0;
            int cy = 0;
            int ans = 0;
            for (int i = 0; i < trees.size(); ++i) {
                int steps = bfs(forest, cx, cy, trees.get(i)[0], trees.get(i)[1]);
                if (steps == -1) {
                    return -1;
                }
                ans += steps;
                cx = trees.get(i)[0];
                cy = trees.get(i)[1];
            }
            return ans;
        }

        public int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
            if (sx == tx && sy == ty) {
                return 0;
            }

            int row = forest.size();
            int col = forest.get(0).size();
            int step = 0;
            Queue<int[]> queue = new ArrayDeque<int[]>();
            boolean[][] visited = new boolean[row][col];
            queue.offer(new int[]{sx, sy});
            visited[sx][sy] = true;
            while (!queue.isEmpty()) {
                step++;
                int sz = queue.size();
                for (int i = 0; i < sz; ++i) {
                    int[] cell = queue.poll();
                    int cx = cell[0], cy = cell[1];
                    for (int j = 0; j < 4; ++j) {
                        int nx = cx + dirs[j][0];
                        int ny = cy + dirs[j][1];
                        if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                            if (!visited[nx][ny] && forest.get(nx).get(ny) > 0) {
                                if (nx == tx && ny == ty) {
                                    return step;
                                }
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }


    public static void main(String[] args) {
        Leetcode675 l = new Leetcode675();
        List<Integer> l1 = new ArrayList<>();
        l1.add(4);
        l1.add(2);
        l1.add(3);
        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(0);
        l2.add(1);
        List<Integer> l3 = new ArrayList<>();
        l3.add(7);
        l3.add(6);
        l3.add(5);

        List<List<Integer>> ll = new ArrayList<>();
        ll.add(l1);
        ll.add(l2);
        ll.add(l3);
        System.out.println(l.cutOffTree(ll));
    }
}
