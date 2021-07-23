package LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2020/3/23 8:54
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 通过
 */
public class Leetcode365 {
    //使用深度遍历，每一次有六种选择，A壶向B壶倒水，B壶向A壶倒水，清空A壶，清空B壶，装满A壶，装满B壶
    //如果回到了某一个已经计算过的状态，那么表示不能够继续倒了
    //直接使用dfs会出现超出递归层数的限制，因此使用queue来替代递归
    public boolean dfs(int a, int b, int c, HashSet<String> set, int A, int B) {

//        for (String y: set
//             ) {
//            System.out.print(y + "");
//        }
//        System.out.println();
        //递归出口
        String s = a + " " + b + " " + c;
        if (set.contains(s)) {
            return false;
        }

        //如果a壶或者b壶中的水刚好是c的大小，那么返回true
        if (a == c || b == c || a + b == c) {
            return true;
        }

        //深度遍历
        set.add(s);
        //装满A壶
        if (dfs(A, b,c, set, A, B)) {
            return true;
        }
        //装满B壶
        if (dfs(a, B, c, set, A, B)) {
            return true;
        }
        //A壶向B壶倒水
        if (dfs((a + b) > B?(a + b - B):0 , Math.min((a + b), B), c, set, A, B)) {
            return true;
        }
        //B壶向A壶倒水
        if (dfs(Math.min((a + b), A), (a + b) > A?(a + b - A):0, c, set, A, B)) {
            return true;
        }
        //清空B壶
        if (dfs(a, 0, c, set, A, B)) {
            return true;
        }
        //清空A壶
        return dfs(0, b, c, set, A, B);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        //return dfs(0,0, z, new HashSet<String>(), x, y);
        Queue<Integer> stackA = new LinkedList<>();
        Queue<Integer> stackB = new LinkedList<>();
        HashSet<String> strings = new HashSet<>();
        //初始状态只能够选择把A壶装满或者把B壶装满
        //装满A壶
        stackA.add(x);
        stackB.add(0);
        strings.add(x + " "+ 0);
        //装满B壶
        stackA.add(0);
        stackB.add(y);
        strings.add(0 + " "+ y);


        while (!stackA.isEmpty()) {
            int a = stackA.poll();
            int b = stackB.poll();
            //检查是否正好存了z升水
            if (a + b == z || a == z || b == z) {
                return true;
            }

            //装满A壶
            if (a != x && !strings.contains(x + " "+b)) {
                stackA.add(x);
                stackB.add(b);
            }
            //装满B壶
            if (b != y && !strings.contains(a + " "+y)) {
                stackA.add(a);
                stackB.add(y);
                strings.add(a + " "+y);
            }
            //清空A壶
            if (a != 0  && !strings.contains(0 + " "+b)) {
                stackA.add(0);
                stackB.add(b);
                strings.add(0 + " "+b);
            }
            //清空B壶
            if (b != 0  && !strings.contains(a + " "+0)) {
                stackA.add(a);
                stackB.add(0);
                strings.add(a + " "+0);
            }
            //将A壶中的水倒入B
            String e = Math.max((a + b) - y, 0) + " " + Math.min(a + b, y);
            if (b != y  && !strings.contains(e)) {
                stackA.add(Math.max((a + b) - y, 0));
                stackB.add(Math.min(a + b, y));
                strings.add(e);
            }
            //将B壶中的水导入A壶
            if (a != x  && !strings.contains(Math.min(a + b, x) + " "+Math.max((a + b - x), 0))) {
                stackA.add(Math.min(a + b, x));
                stackB.add(Math.max((a + b - x), 0));
                strings.add(Math.min(a + b, x) + " "+ Math.max((a + b - x), 0));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Leetcode365 leetcode365 = new Leetcode365();
        System.out.println(leetcode365.canMeasureWater(104707,104711,1));
    }
}
