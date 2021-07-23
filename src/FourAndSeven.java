/**
 * @author hyy
 * @date 2020/2/29 8:47
 */

import java.util.*;

/**
 * 每一位都是4和7的整数倍称为邪数，例如44,74,7477
 * 求任意一个整数至少是右几个邪恶数求和得出，
 * 例如:15=7+4+4,最少三个
 * 481=477+4最少两个*/
public class FourAndSeven {
    /**
     * 思路：
     * 对于一个整数n，假设当前n-m-4...=0，那么就有可能n-m-4-7..=0或者n-m-4-4..=0或者n-m+-47..=0或者n-m-44..=0
     * 因此可以采用深度遍历的方式，然后为了减少计算量，采用记忆搜索，也就是将计算出来的结果保存下来
     * @param num 代表当前的要求的数
     * @param nowCount 代表当前用了几个数
     * @param now 代表表达式最后一个数
     * */

    static int min = Integer.MAX_VALUE;
    public static Queue<Integer> list = new LinkedList<>();

    public void dfs(int num, int now, Queue<Integer> minList, int level) {
        //如果num = 0, 那么就不用数字表示
        if (num == 0) {

            if (level < min) {
                list.clear();
                list.addAll(minList) ;
            }
            min = Math.min(level, min);
            return;
        }

        //如果num<0,那么表示这个数不可以用此顺序表示
        if (num < 0) {
            return;
        }
        //下面进行递归
        //剪枝
        if (level >= min) {
            return;
        }
        //递归,求解num最少可以被多少个数表示
        Queue<Integer> new1 = new LinkedList<>(minList);
        Queue<Integer> new2 = new LinkedList<>(minList);
        Queue<Integer> new3 = new LinkedList<>(minList);
        Queue<Integer> new4 = new LinkedList<>(minList);
        new1.add(4);
        new2.add(7);
        dfs(num - 4, 4, new1,level + 1);
        dfs(num - 7, 7,  new2, level + 1);
        if (now != 0) {
            Integer poll = new3.poll();
            new3.add(poll * 10 + 4);
            Integer poll1 = new4.poll();
            new4.add(poll1*10 + 7);
            dfs(num + now - now*10 - 4, now * 10 + 4, new3, level);
            dfs(num + now - now*10 - 7, now * 10 + 7, new4, level);
        }
    }

    public static void main(String[] args) {
        FourAndSeven fourAndSeven = new FourAndSeven();
        Scanner in = new Scanner(System.in);
        int i = 0;
        while (i++ < 10) {
            int n = in.nextInt();
            list.clear();
            min = Integer.MAX_VALUE;
            Queue<Integer> minList = new LinkedList<>();
            fourAndSeven.dfs(n, 0, minList, 0);
            System.out.println(min == Integer.MAX_VALUE?-1:min);
            System.out.println(Arrays.toString(list.toArray()));
        }
        }

}
