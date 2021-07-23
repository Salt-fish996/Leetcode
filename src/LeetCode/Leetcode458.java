package LeetCode;

public class Leetcode458 {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int x = minutesToTest/minutesToDie + 1;//计算每只小猪可以验证多少桶(也就是几进制）
        int sum = 1;
        int count = 1;
        while ((sum = (int)Math.pow(2,count))<buckets){
            count++;
        }
        return count;
    }
}
