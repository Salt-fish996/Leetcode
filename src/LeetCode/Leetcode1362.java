package src.LeetCode;

public class Leetcode1362 {
    public int[] closestDivisors(int num) {

        int n1 = (int) Math.sqrt(num+1);
        int n11 = 0,n12 = 0;
        for (int i = n1; i >=1 ; i--) {
            if ((num+1) %i == 0) {
                n11 = i;
                n12 = (num+1) / i;
                break;
            }
        }

       n1 = (int) Math.sqrt(num+2);
        int n21 = 0,n22 = 0;
        for (int i = n1; i >=1 ; i--) {
            if ((num+2) %i == 0) {
                n21 = i;
                n22 = (num+2) / i;
                break;
            }
        }
        if (Math.abs(n12-n11) > Math.abs(n22-n21)) {
            return new int[]{n21,n22};
        }
        return new int[]{n11,n12};
    }

}
