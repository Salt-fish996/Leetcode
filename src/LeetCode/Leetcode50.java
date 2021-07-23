package LeetCode;

import java.text.DecimalFormat;

public class Leetcode50 {
    public double myPow(double x, int n) {

        DecimalFormat df = new DecimalFormat( "0.00000 ");
        double result = Math.pow(x,n);
        return Double.parseDouble(df.format(result));
    }
}
