package PinDuoDuo;

import java.util.Scanner;

/**
 * @author hyy
 * @date 2019/12/5 19:51
 */
public class Leetcode2019120502 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int a = in.nextInt();
        int r = in.nextInt();
        //最后一次必须至少拿m-a+1个，如果拿不到，可能性为0
        if (m - a  <= r){
            System.out.println("1.00000");
        }

    }

}
