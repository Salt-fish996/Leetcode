package BaiDuCamups;

import java.util.*;

/**
 * @author hyy
 * @date 2020/3/14 19:34
 */
//60%
public class Two {


    //用于返回在某个状态下的能发的最多工资
    public int max(ArrayList<Integer> money, ArrayList<Integer> count, int k, int now, HashMap<String, Integer> hashMap) {
        //如果已经计算过了，那么直接返回
        String tempStr = Arrays.toString(money.toArray()) + " "+ Arrays.toString(count.toArray()) + " "+now;
        if (hashMap.containsKey(tempStr)) {
            return hashMap.get(tempStr);
        }
        //如果所有的钱都不够付一个月的工资了，那么返回
        int total = now;
        for (int i = 0; i < money.size(); i++) {
            total += money.get(i) * count.get(i);
        }
        if (total < k) {
            return 0;
        }
        //now 表示现在发工资的桌上的钱，那么在money中可以选择一个放在桌上
        int maxCount = 0;
        for (int i = 0; i < money.size(); i++) {
            if (count.get(i) > 0) {
                int temp = now + money.get(i);
                count.set(i, count.get(i) - 1);
                if (temp >= k) {
                    maxCount = Math.max(maxCount, 1 + max(money, count, k, 0,hashMap));
                } else {
                    maxCount = Math.max(maxCount, max(money, count, k, temp,hashMap));
                }
                count.set(i,count.get(i) + 1);
            }
        }
        hashMap.put(tempStr, maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        int result = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int moneyTemp = in.nextInt();
            int countTemp = in.nextInt();
            treeMap.put(moneyTemp, countTemp);
        }
        //将treeMap中的数取出
        ArrayList<Integer> money = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        //所有不小于m的金额都可以直接用于发放工资
        for (int v:treeMap.keySet()
             ) {
            if (v >= m) {
                result += treeMap.get(v);
                treeMap.put(v, 0);
            } else {
                money.add(v);
                count.add(treeMap.get(v));
            }
        }
        Two two = new Two();
        //计算剩下的钱能够支付几个月的
        HashMap<String, Integer> hashMap = new HashMap<>();
        System.out.println(result + two.max(money, count, m, 0, hashMap));
    }
}
