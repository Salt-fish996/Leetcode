package src.LeetCode;

import java.io.*;
import java.util.*;

//24点游戏
public class Leetcode679 {
    static double threshold = 1E-6;
    private boolean check(double[] nums,int n,String[] result){
        if (n == 1){
            if (Math.abs(nums[0] - 24)<threshold){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        File file = new File("C:\\Users\\Administrator\\Desktop\\24point.txt");
                        if (!file.exists()){
                            try {
                                file.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
                            out.write(result[0] + "\n");
                            out.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                System.out.println(result[0]);
                return true;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double a = nums[i];
                double b = nums[j];
                String expa = result[i];
                String expb = result[j];
                String temp = result[i];
                nums[j] = nums[n-1];
                result[j] = result[n-1];
                result[i] = "(" + expa + "+" + expb + ")";
                nums[i] = a + b;

                if (check(nums,n-1,result)){
                    return true;
                }

                result[i] = "(" + expa +"-"+ expb + ")";
                nums[i] = a - b;
                if (check(nums,n-1,result)){
                    return true;
                }

                result[i] = "(" + expb +"-"+ expa + ")";
                nums[i] = b - a;
                if (check(nums,n-1,result)){
                    return true;
                }

                result[i] = "(" + expa +"*"+ expb + ")";
                nums[i] = a * b;
                if (check(nums,n-1,result)){
                    return true;
                }

                if (b!=0){
                    result[i] = "(" + expa +"/"+ expb + ")";
                    nums[i] = a / b;
                    if (check(nums,n-1,result)){
                        return true;
                    }
                }

                if (a!=0){
                    result[i] = "(" + expb +"/"+ expa + ")";
                    nums[i] = b / a;
                    if (check(nums,n-1,result)){
                        return true;
                    }
                }
                result[i] = expa;
                result[j] = expb;
                nums[i] = a;
                nums[j] = b;
            }
        }
        return false;
    }
    public boolean judgePoint24(double[] nums) {

        System.out.println("nums="+Arrays.toString(nums));
        int n = nums.length;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = "" +  nums[i];
        }
        boolean f = check(nums,n,result);
        return f;

    }

    public static void main(String[] args) {
        Leetcode679 leetcode679 = new Leetcode679();
        double[] a = new double[4];
        Scanner in = new Scanner(System.in);

        int count = 0;

            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < 10; j++) {

                    for (int k = 0; k < 10; k++) {

                        for (int l = 0; l < 10; l++) {
                            a[2] = k;
                            a[1] = j;
                            a[0] = i;
                            a[3] = l;
                            System.out.println("count="+count+++"  "+leetcode679.judgePoint24(a));
                        }
                    }
                }
            }



//        double[] a = new double[]{4,1,8,7};
//        double[] a1 = new double[]{5,4,5,7};
//        double[] a2 = new double[]{8,1,6,6};
//        double[] a3 = new double[]{3,3,8,8};
//        System.out.println(leetcode679.judgePoint24(a));
//        System.out.println(leetcode679.judgePoint24(a3));
//        System.out.println(leetcode679.judgePoint24(a1));
//        System.out.println(leetcode679.judgePoint24(a2));
    }
}
