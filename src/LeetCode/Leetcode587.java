package LeetCode;

import java.util.*;

/**
 * @author hyy
 * @date 2019/11/28 15:02
 */
//未通过
public class Leetcode587 {
    public int[][] outerTrees(int[][] points) {

        //这个题就是找每一个横坐标对应的最大最小值
        //使用hashMap来存储对应每一个横坐标对应的纵坐标最大值和最小值
        HashMap<Integer,Integer> hashMapMax = new HashMap<>();
        HashMap<Integer,Integer> hashMapMin = new HashMap<>();
        int m = points.length;
        //首先找到最小的横左边和纵坐标以及最大的横坐标和纵坐标
        int minRow = Integer.MAX_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        int maxRowValue = 0;
        int minRowValue = 0;
        //使用list来保存结果
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int nowCol = points[i][1];
            int nowRow = points[i][0];
            if (hashMapMax.get(nowRow) == null || hashMapMax.get(nowRow)<nowCol){
                hashMapMax.put(nowRow,nowCol);
            }
            if (hashMapMin.get(nowRow) == null || hashMapMin.get(nowRow)>nowCol){
                hashMapMin.put(nowRow,nowCol);
            }
            maxRowValue = nowCol > maxCol?nowRow:maxRowValue;
            minRowValue = nowCol < minCol?nowRow:minRowValue;
            minRow = Math.min(points[i][0],minRow);
            minCol = Math.min(points[i][1],minCol);
            maxCol = Math.max(points[i][1],maxCol);
            maxRow = Math.max(points[i][0],maxRow);

        }

        int last = maxRow;
        //存储每一行的最大值
        for (int i = minRow; i < maxRow; i++) {
            if (!hashMapMax.containsKey(i)){
                continue;
            }
            int maxColNow = hashMapMax.get(i);
            //计算的点在最大的点左边
            if (i < maxRowValue){
                //计算上斜率
                //计算其间的最大的纵坐标
                for (int j = i + 1; j < maxRowValue; j++) {
                    if (!hashMapMax.containsKey(j)){
                        continue;
                    }
                    int tempCol = hashMapMax.get(j);
                    if ((tempCol - maxColNow) * (maxRowValue - i) <= (maxCol - maxColNow)*(j - i)){
                        if ((tempCol - maxColNow) * (maxRowValue - i) != (maxCol - maxColNow)*(j - i)){
                            hashMapMax.put(j,tempCol + 1);
                        }
                    }else {
                        for (int k = i + 1; k < j; k++) {
                            if (hashMapMax.containsKey(k)){
                                hashMapMax.put(k,hashMapMax.get(k) + 1);
                            }
                        }
                        i = j - 1;
                        break;
                    }
                }
                //在最高的点右边
            }else {
                int lastEnd = maxRow;
                for (int k = maxRow; k > maxRowValue ; k--) {
                    if (!hashMapMax.containsKey(k)){
                        continue;
                    }
                    //计算上斜率
                    //计算其间的最大的纵坐标
                    maxColNow = hashMapMax.get(k);
                    for (int j = k - 1; j > maxRowValue; j--) {
                        if (!hashMapMax.containsKey(j)){
                            continue;
                        }
                        int tempCol = hashMapMax.get(j);
                        if ((tempCol - maxColNow) * (k - maxRowValue) <= (maxColNow - maxCol)*(j - k)){
                            if ((tempCol - maxColNow) * (k - maxRowValue) != ( maxColNow - maxCol)*(j - k)){
                                hashMapMax.put(j,tempCol + 1);
                            }
                        }else {
                            for (int l = j + 1; l < k; l++) {
                                if (hashMapMax.containsKey(l)){
                                    hashMapMax.put(l,hashMapMax.get(l) + 1);
                                }
                            }
                            k = j + 1;
                            break;
                        }
                    }

                }
                break;
                }
        }


        last = maxRow;
        //存储每一行的最小值
        for (int i = minRow; i < minRowValue; i++) {
            if (!hashMapMin.containsKey(i)){
                continue;
            }
            int minColNow = hashMapMin.get(i);
            //计算的点在最大的点左边
            //计算上斜率
            //计算其间的最小的纵坐标
            for (int j = i + 1; j < minRowValue; j++) {
                if (!hashMapMin.containsKey(j)){
                    continue;
                }
                int tempCol = hashMapMin.get(j);
                if ((tempCol - minColNow) * (minRowValue - i) >= (minCol - minColNow)*(j-i)){
                    if ((tempCol - minColNow) * (minRowValue - i) != (minCol - minColNow)*(j-i)){
                        hashMapMin.put(j, tempCol- 1);
                    }
                }else {
                    for (int k = i + 1; k < j; k++) {
                        if (hashMapMin.containsKey(k)){
                            hashMapMin.put(k,hashMapMin.get(k) - 1);
                        }
                    }
                    i = j - 1;
                    break;
                }
            }
            //在最高的点右边
        }


        //计算上斜率
        //计算其间的最小的纵坐标
        int tempmaxRow = maxRow;
        for (int k = maxRow; k > minRowValue ; k--) {
            if (!hashMapMin.containsKey(k)){
                continue;
            }
            int minColNow = hashMapMin.get(k);
            for (int j = minRowValue; j < maxRow; j++) {
                if (!hashMapMin.containsKey(j)){
                    continue;
                }
                int tempCol = hashMapMin.get(j);
                if ((tempCol - minColNow) * (k - minRowValue) >= (minColNow - minCol)*(j-k)){
                    if ((tempCol - minColNow) * (k - minRowValue) != (minColNow - minCol)*(j-k)){
                        hashMapMin.put(j, - 1);
                    }
                }else {
                    for (int l = j + 1; l < k; l++) {
                        if (hashMapMax.containsKey(l)){
                            hashMapMin.put(l,hashMapMin.get(l) - 1);
                        }
                    }

                    break;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int nowRow = points[i][0];
            int nowCol = points[i][1];
            if (nowRow == minRow || nowRow == maxRow){
                row.add(nowRow);
                col.add(nowCol);
            }else {
                int min = hashMapMin.get(nowRow);
                int max = hashMapMax.get(nowRow);
                if (nowCol == min || nowCol == max){
                    row.add(nowRow);
                    col.add(nowCol);
                }
            }

        }

        int[][] result = new int[row.size()][2];
        for (int i = 0; i < row.size(); i++) {
            result[i][0] = row.get(i);
            result[i][1] = col.get(i);
        }

        return result;

    }

    public static void main(String[] args) {
        Leetcode587 leetcode587 = new Leetcode587();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] strings = s.split("],");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replace("[","");
        }
        int[][] g = new int[strings.length][2];
        for (int i = 0; i < strings.length; i++) {
            char c = strings[i].charAt(0);
            g[i][0] = c - '0';
            c = strings[i].charAt(2);
            g[i][1] = c - '0';
        }

        char[][] h = new char[10][10];
        for (int i = 0; i < g.length; i++) {
            h[g[i][1]][g[i][0]] = 'O';
        }
        for (int i = 9; i >= 0; i--) {
            System.out.println(Arrays.toString(h[i]));
        }
        int[][] r = leetcode587.outerTrees(g);
        for (int i = 0; i < r.length; i++) {
            System.out.println(Arrays.toString(r[i]));
        }
    }
}
