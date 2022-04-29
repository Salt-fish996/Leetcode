package src.LeetCode;

public class Leetcode427 {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };
    public Node construct(int[][] grid) {
        return dfsConstruct(grid,0,0,grid.length);
    }

    // (x,y)为左上角的点
    public Node dfsConstruct(int[][] grid, int x,int y, int len) {
        if (len == 1) {
            return new Node(grid[x][y] == 1,true);
        }
        int m = -1;
        boolean same = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (m == -1) {
                    m = grid[x+i][y+j];
                } else if (m != grid[x+i][y+j]) {
                    same = false;
                    break;
                }
            }
        }
        if (same) {
            return new Node(grid[x][y] == 1,true);
        }
        int newLen = len /2;
        return new Node(true,false,dfsConstruct(grid,x,y,newLen),dfsConstruct(grid,x,y+newLen,newLen),dfsConstruct(grid,x+newLen,y,newLen),dfsConstruct(grid,x+newLen,y+newLen,newLen));
    }

    public static void main(String[] args) {
        String s = "[[0,1],[1,0]]";
        String[] ss = s.split("],");
        int row = ss.length;
        int col = ss[0].split(",").length;
        int[][] grid = new int[row][col];

        for (int i = 0; i < row; i++) {
            String[] sss = ss[i].replace("[", "").replace("]", "").split(",");
            for (int j = 0; j < col; j++) {
                grid[i][j] = Integer.parseInt(sss[j]);
            }
        }
        Leetcode427 l = new Leetcode427();
        System.out.println(l.construct(grid));
    }
}
