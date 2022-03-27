package LeetCode;

import java.util.*;

// 没有通过的，方法不是很好
public class Leetcode638 {
    Map<String,Integer> minCost = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 使用记忆化搜索的方式,只需要记录每一种组合的最小的购买金额，由于是多个商品，因此需要定义一个结构来存储能够获取的数据的最小值
        // 以此来加快程序的搜索
        minCost = new HashMap<>();
        return this.minCostDeal(price,special,needs);
    }
    // 计算l1-l2
    public List<Integer> subTraction(List<Integer> l1,List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < l1.size(); i ++) {
            res.add(l1.get(i) - l2.get(i));
        }
        return res;
    }

    public int minCostDeal(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        boolean flag = true;
        // 检查needs中的每一个数都必须要是大于0的
        for (int i = 0; i < n; i++) {
            int v = needs.get(i);
            if (v < 0) {
                return Integer.MAX_VALUE;
            }
            if (v != 0) {
                flag = false;
            }
        }
        // needs中全是0了就没有必要处理了
        if (flag) {
            return 0;
        }
        // 记忆搜索，取最小值
        String needStr = Arrays.toString(needs.toArray());
        if (this.minCost.get(needStr) != null && this.minCost.get(needStr) != Integer.MAX_VALUE) {
            return this.minCost.get(needStr);
        }
        int min = Integer.MAX_VALUE;
        // 对于每一个needs， 可以选择price里面的，也可以选择special里面的
        for (int i = 0;i < n; i++) {
            // 选择price里面的
            int v = needs.get(i);
            needs.set(i,v -1);
            int tmp = this.minCostDeal(price,special,needs);
            if (tmp == Integer.MAX_VALUE) {
                needs.set(i,v);
                continue;
            }
            if (this.minCost.get(needStr) == null || this.minCost.get(needStr) > price.get(i)+tmp) {
                this.minCost.put(needStr,price.get(i)+tmp);
               min = price.get(i)+tmp;
            }
            needs.set(i,v);
        }
        // 选择特殊商品
        for (int i = 0; i < special.size(); i++) {
            List<Integer> nextNeeds = this.subTraction(needs,special.get(i));
            int tmp = this.minCostDeal(price,special,nextNeeds);
            if (tmp == Integer.MAX_VALUE) {
                continue;
            }
            int specialPrice = special.get(i).get(special.get(i).size() -1);
            if (this.minCost.get(needStr) == null || this.minCost.get(needStr) > tmp + specialPrice) {
                this.minCost.put(needStr,specialPrice + tmp);
                min = specialPrice + tmp;
            }
        }
        System.out.println("needs:"+needStr+"\ncost:"+min);
        return min;
    }

    public static void main(String[] args) {
        Leetcode638 l = new Leetcode638();
        List<Integer> prices = new ArrayList<Integer>();
        List<List<Integer>> specials = new ArrayList<>();
        List<Integer> needs = new ArrayList<>();

        prices.add(2);prices.add(5);
        needs.add(1);needs.add(2);

        List<Integer> t = new ArrayList<>();
        t.add(3);t.add(0);t.add(5);
        specials.add(t);
        t = new ArrayList<>();
        t.add(1);t.add(2);t.add(10);

        System.out.println(l.shoppingOffers(prices, specials, needs));
        System.out.println("...");

    }
}
