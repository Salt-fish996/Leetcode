package src.LeetCode;

//计算各个位置数字均不相同的数目个数，通过
public class Leetcode357 {
    public int countNumbersWithUniqueDigits(int n) {

        int sum = 10;
        int count = 9;
        int temp = 9;
        if (n == 0) {
            return 1;
        }else if (n == 1){
            return sum;
        }else{

            for (int i = 2; i <= n && count > 0; i++) {
                temp *= count--;
                sum += temp;
            }
        }
        return sum;
    }
}
