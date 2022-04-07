package src.LeetCode;

import java.util.*;

public class Leetcode310 {
    // 超时。通过67/70
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        // 统计与每一个点直接连接的点
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            List<Integer> l1 = map.getOrDefault(edges[i][0],new ArrayList<>());
            l1.add(n2);
            map.put(edges[i][0],l1);
            List<Integer> l2 = map.getOrDefault(edges[i][1],new ArrayList<>());
            l2.add(n1);
            map.put(edges[i][1],l2);
        }

        int min = Integer.MAX_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        int[] status = new int[n];
        for (int i = 0; i < n; i++) {
            // 首先把只有一个连接点的排除
            if (map.get(i).size() == 1) {
                continue;
            }
            int m = dfs(i,map,status,min,0);
            if (min > m) {
                min = m;
                res.clear();
                res.add(i);
            } else if (min == m) {
                res.add(i);
            }
        }
        return res;
    }
    // 深度遍历
    public int dfs(int x, Map<Integer, List<Integer>> map, int[] status,int minM, int now) {
        String k = x + Arrays.toString(status);
        // status 标识结点状态，status=1标识已经走过了
        // 获取所有的关联结点
        List<Integer> p = map.get(x);
        if (p == null) {
            return 0;
        }
        // 减少遍历
        if (now >= minM) {
            return minM;
        }
        status[x] = 1;
        int min = 0;
        for (int i = 0; i < p.size(); i++) {
            if (status[p.get(i)] != 1) {
                min = Math.max(min,dfs(p.get(i),map,status,minM,now+1)+1);
            }
        }
        status[x] = 0;
        return min;
    }

    // 拓扑排序
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] du = new int[n];
        Queue<Integer> q = new LinkedList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        // 统计与每一个点直接连接的点
        for (int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            List<Integer> l1 = map.getOrDefault(edges[i][0],new ArrayList<>());
            l1.add(n2);
            map.put(edges[i][0],l1);
            List<Integer> l2 = map.getOrDefault(edges[i][1],new ArrayList<>());
            l2.add(n1);
            map.put(edges[i][1],l2);
            du[edges[i][0]]++;
            du[edges[i][1]]++;
        }
        for (int i = 0; i < n; i++) {
            if (du[i] == 1) {
                q.add(i);
            }
        }
        int remainCount = n;
        while (remainCount > 2) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                remainCount--;
                int index = q.poll();
                du[index]--;
                List<Integer> l = map.get(index);
                for (int j = 0; j < l.size(); j++) {
                    int k = l.get(j);
                    du[k]--;
                    if (du[k] == 1) {
                        q.add(k);
                    }
                }
            }
        }
        int c =  q.size();
        for (int i = 0; i < c; i++) {
            res.add(q.poll());
        }
        return res;
    }

    public void remove(int n, int[][] du) {

    }

    public static void main(String[] args) {
        Leetcode310 l = new Leetcode310();
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        System.out.println(l.findMinHeightTrees(6,edges));
        System.out.println(l.findMinHeightTrees(1,new int[0][0]));
    }
}
