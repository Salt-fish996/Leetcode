package src.LeetCode;

import java.util.*;

public class Leetcode1606 {

    // 通过 211ms
    public List<Integer> busiestServers1(int k, int[] arrival, int[] load) {
        // 使用一个数组 busy 表示当前服务器下次空闲的时间，使用数组count表示服务器服务的数量
        int[] busy = new int[k];
        int[] count = new int[k];
        // 以 结束时间升序
        TreeSet<Integer> workTo= new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (busy[o1] == busy[o2]) {
                    return o1-o2;
                }
                return busy[o1] - busy[o2];
            }
        }); // 保存空闲的服务器
        for (int i = 0; i < k; i++) {
            workTo.add(i);
        }
        // 以服务器编号排序
        TreeSet<Integer> freeMachine = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < load.length; i++) {
            while (!workTo.isEmpty()) {
                int t = workTo.pollFirst();
                if (busy[t] <= arrival[i]) {
                    freeMachine.add(t);
                } else {
                    workTo.add(t);
                    break;
                }
            }

            // 找第一个机器
            Integer server = freeMachine.higher(i%k-1);
            if (server == null) {
                server = freeMachine.higher(-1);
            }
            if (server == null ) {
                continue;
            }
            freeMachine.remove(server);
            // 找到了server服务器
            busy[server] = arrival[i]+load[i];
            count[server]++;
            workTo.add(server);
            max = Math.max(max,count[server]);

//            for (int j=index;j < k+index; j++) {
//                if (busy[j%k] <= arrival[i]) {
//                    // 找到了对应的服务器
//                    count[j%k]++; // 服务数目+1
//                    max = Math.max(max,count[j%k]);
//                    busy[j%k] = arrival[i]+load[i]; // 结束时间
//                    break;
//                } else if(i < load.length -1 && busy[j%k] > arrival[i+1]) {
//                    set.add(j);
//                }
//            }
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                l.add(i);
            }
        }
        return l;
    }


    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // 使用一个数组 busy 表示当前服务器下次空闲的时间，使用数组count表示服务器服务的数量
        int[] busy = new int[k];
        int[] count = new int[k];
         // 保存空闲的服务器
        PriorityQueue<Integer> workToQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (busy[o1] == busy[o2]) {
                    return o1-o2;
                }
                return busy[o1] - busy[o2];
            }
        });
        for (int i = 0; i < k; i++) {
            workToQueue.add(i);
        }
        // 以服务器编号排序
        TreeSet<Integer> freeMachine = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < load.length; i++) {
            while (!workToQueue.isEmpty()) {
                int t = workToQueue.poll();
                if (busy[t] <= arrival[i]) {
                    freeMachine.add(t);
                } else {
                    workToQueue.add(t);
                    break;
                }
            }

            // 找第一个机器
            Integer server = freeMachine.higher(i%k-1);
            if (server == null) {
                server = freeMachine.higher(-1);
            }
            if (server == null ) {
                continue;
            }
            freeMachine.remove(server);
            // 找到了server服务器
            busy[server] = arrival[i]+load[i];
            count[server]++;
            workToQueue.add(server);
            max = Math.max(max,count[server]);

//            for (int j=index;j < k+index; j++) {
//                if (busy[j%k] <= arrival[i]) {
//                    // 找到了对应的服务器
//                    count[j%k]++; // 服务数目+1
//                    max = Math.max(max,count[j%k]);
//                    busy[j%k] = arrival[i]+load[i]; // 结束时间
//                    break;
//                } else if(i < load.length -1 && busy[j%k] > arrival[i+1]) {
//                    set.add(j);
//                }
//            }
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (count[i] == max) {
                l.add(i);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Leetcode1606 l = new Leetcode1606();
        System.out.println(l.busiestServers(3,new int[]{1,2,3,4,8,9,10},new int[]{5,2,10,3,1,2,2}));
    }
}
