package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//机器人大冒险，通过
public class LCP3 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {

        //用一个HashMap来存储障碍，key是障碍点的横坐标，value是纵坐标
        HashMap<Integer, Set<Integer>> hashMap = new HashMap<>();
        int count = 0;//命令执行的位置
        int nowX = 0;//现在的横坐标
        int nowY = 0;//现在的纵坐标
        int m = obstacles.length;
        //初始化障碍点记录hashMap
        for (int i = 0; i < m; i++) {
            if (hashMap.get(obstacles[i][0]) == null){
                Set<Integer> set = new HashSet<>();
                set.add(obstacles[i][1]);
                hashMap.put(obstacles[i][0],set);
            }else {
                HashSet<Integer> set = (HashSet<Integer>) hashMap.get(obstacles[i][0]);
                set.add(obstacles[i][1]);
                hashMap.put(obstacles[i][0],set);
            }
        }
        while (true){
            if (nowX == x && nowY == y){
                return true;
            }

            if (nowX > x || nowY > y){//越界
                return false;
            }

            //判断障碍
            if (hashMap.get(nowX) != null && hashMap.get(nowX).contains(nowY)){
                return false;
            }

            if (command.charAt(count) == 'U'){
                nowY++;
            }else if (command.charAt(count) == 'R'){
                nowX++;
            }
            count++;
            if (count == command.length()){
                count = 0;
            }
        }
    }
}
