package BaiDuCamups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author hyy
 * @date 2020/3/14 20:15
 */
//10%
public class Three {

    //表示牛牛能不能赢，返回true表示能够赢，返回false表示不能赢
    public boolean chose(boolean flag, Set<Integer> black, Set<Integer> white,Set<Integer> space, HashMap<Integer, Set<Integer>> links) {
        //flag=true表示牛牛选，false表示牛妹选
        if (flag) {
            boolean result = false;
            //牛牛选的时候如果已经没有能够涂成黑色的点，那么牛牛失败
            //遍历所有黑色的点
            boolean f = false;
            for (Integer v:black
                 ) {
                Set<Integer> set = links.get(v);
                for (int v1:set
                     ) {
                    //如果能选，那么进行递归
                    if (space.contains(v1)) {
                        space.remove(v1);
                        black.add(v1);
                        result = chose(false,black,white,space,links);
                        space.add(v1);
                        black.remove(v1);
                        if (result) {
                            return true;
                        }
                    }
                }

            }
            //能够选的情况下，进行递归
            return false;
        } else {
            //牛妹选的时候
            boolean result = true;
            //牛每选的时候如果已经没有能够涂成白色的点，那么牛妹失败
            //遍历所有黑色的点
            for (Integer v:white
            ) {
                Set<Integer> set = links.get(v);
                for (int v1:set
                ) {
                    //如果能选，那么进行递归
                    if (space.contains(v1)) {
                        space.remove(v1);
                        white.add(v1);
                        result = chose(true,black,white,space,links);
                        space.add(v1);
                        white.remove(v1);
                        if (!result) {
                            return false;
                        }
                    }
                }

            }
            //能够选的情况下，进行递归
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            //用一个HashMap记录与某个点连接的点
            HashMap<Integer, Set<Integer>> links = new HashMap<>();
            //用一个集合来记录所有白点
            Set<Integer > white = new HashSet<>();
            //用一个集合来记录所有的黑点
            Set<Integer> black = new HashSet<>();
            //用一个集合来记录所有的空点
            Set<Integer> space = new HashSet<>();

            int n = in.nextInt();

            //记录最小点min,记录最大点max，记录所有的点
            int min = 0;
            int max = 0;
            for (int j = 0; j < n - 1; j++) {
                int tempX = in.nextInt();
                int tempY = in.nextInt();
                //放入black中
                space.add(tempX);
                space.add(tempY);
                if (!links.containsKey(tempX)) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    hashSet.add(tempY);
                    links.put(tempX, hashSet);
                } else {
                    Set<Integer> hashSet = links.get(tempX);
                    hashSet.add(tempY);
                    links.put(tempX,hashSet);
                }

                if (!links.containsKey(tempY)) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    hashSet.add(tempX);
                    links.put(tempY, hashSet);
                }  else {
                    Set<Integer> hashSet = links.get(tempY);
                    hashSet.add(tempX);
                    links.put(tempY,hashSet);
                }

            }
            space.remove(1);
            space.remove(n);
            white.add(n);
            black.add(1);
            Three three = new Three();
            if (three.chose(true, black,white, space,links)) {
                System.out.println("niuniu");
            } else {
                System.out.println("niumei");
            }
        }
    }
}
