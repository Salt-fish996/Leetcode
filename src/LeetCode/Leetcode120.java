package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyy
 * @date 2019/9/10 17:07
 */
public class Leetcode120 {
    public int find(List<List<Integer>> lists, int n, int now,int[][] mini ){//n代表第几层，now表示现在的位置
        if (n == lists.size()){//如果访问到了最后一层，那么返回
            return lists.get(n-1).get(now);
        }else {
            //如果已经计算过了从当前位置到最后一层的最短路径，那么就不用再次计算，直接返回最短路径
            if (mini[n-1][now] != 0) return mini[n-1][now];
            int vertical = 0;
            int right = 0;
            //选择右下的位置
            if (now+1 < lists.get(n).size() ){
                right = find(lists,n+1,now+1,mini);
            }
            //选择左下的位置
            if (now < lists.get(n).size()){
                vertical = find(lists,n+1,now,mini);
            }
            //将从n层的第now+1个元素开始到最后一层的最短路劲保存到记录数组中去
            mini[n-1][now] = lists.get(n-1).get(now) + Math.min(right,vertical);
            return mini[n-1][now];
        }
    }
    public int minimumTotal(List<List<Integer>> triangle) {

        //初始化最短路径记录数组
        int[][] mini = new int[triangle.size()][triangle.size()];
        //如果列表中没有内容直接返回
        if (triangle.size() == 0) return 0;
        return find(triangle,1,0,mini);
    }

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        l1.add(2);
        l2.add(3);
        l2.add(4);
        l3.add(6);
        l3.add(5);
        l3.add(7);
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        Leetcode120 leetcode120 = new Leetcode120();
        System.out.println(leetcode120.minimumTotal(lists));


    }

}
