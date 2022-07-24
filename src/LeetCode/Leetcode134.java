package src.LeetCode;

public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int result = -1;
        if (gas.length ==0) return -1;
        for (int i = 0; i < gas.length; i++) {
            int amount = gas[i];//开始时的汽油
            int dig = (i == (gas.length-1)?0:(i+1));//代表下一个加油站
            int now = i;
            while (dig != i){
                if (amount - cost[now] >=0){
                    amount =amount+ gas[dig]-cost[now];
                    dig = dig == gas.length-1?0:(dig+1);
                    now = now == gas.length-1?0:(now+1);
                }else break;
            }
            if (dig == i && amount - cost[now] >= 0){
                result = i;
                break;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[] gas = {5,8,2,8};
        int[] cost = {6,5,6,6};
//        int[] gas = {2,3,4};
//        int[] cost = {3,4,3};
//        int[] gas = {1,2,3,4,5};
//        int[] cost = {3,4,5,1,2};
//        int[] gas = {3,3,4};
//        int[] cost = {3,4,4};
        Leetcode134 leetcode134 = new Leetcode134();
        System.out.println(leetcode134.canCompleteCircuit(gas,cost));
    }
}
