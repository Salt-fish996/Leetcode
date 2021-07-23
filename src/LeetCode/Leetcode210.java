package LeetCode;

import java.util.*;

//课程表II，通过
public class Leetcode210 {
    /**分析：
     * 对有向图进行拓扑排序，如果发现不能够进行拓扑排序，也就是不能形成一个含有0-n-1的序列
     * 那么就不可能完成学习，反之，如果能够完成拓扑排序，那么证明可以完成学习
     * 具体做法：
     * 统计每一门课程的入度，用数组enterCount[]表示，enter[i]便是学习课程i前需要学习的课程数
     * 然后还需要统计每个节点的前置课程都有哪些，这里用*/
    public int[] canFinish(int numCourses, int[][] prerequisites) {

        List<Integer> list = new ArrayList<>();
        int m = prerequisites.length;
        Set[] sets = new HashSet[numCourses];//用于存储每个节点的前驱
        int[] enterCount = new int[numCourses];//用于记录每个节点的前驱个数
        for (int i = 0; i < numCourses; i++) {
            sets[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < m; i++) {
            enterCount[prerequisites[i][0]]++;
            sets[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        while (true){
            int count = 0;
            for (int i = 0; i < numCourses; i++) {
                if (enterCount[i] == 0){
                    enterCount[i] --;
                    list.add(i);//如果入度为0，那么就可以将其加入拓扑排序结果中
                    for (int j = 0; j < numCourses; j++) {
                        if (sets[j].contains(i)){
                            sets[j].remove(i);
                            enterCount[j]--;
                        }
                    }
                }else count++;
            }
            if (count == numCourses) break;
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!list.contains(i)) return new int[]{};;
            result[i] = list.get(i);
        }

        return result;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        return canFinish(numCourses,prerequisites);

    }

    public static void main(String[] args) {
        Leetcode210 leetcode210 = new Leetcode210();
        int[][] a = new int[1][2];
        a[0] = new int[]{1,0};
        //a[1] = new int[]{0,1};
        System.out.println(Arrays.toString(leetcode210.canFinish(2, a)));
    }
}
