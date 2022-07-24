package src.LeetCode;

import java.util.HashMap;
import java.util.Scanner;

//整数转英文,通过
public class Leetcode273 {
    //首先定义1-20
    static String[] stringsOneToNineteen = new String[]{"One","Two","Three","Four","Five","Six","Seven"
            ,"Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
            "Seventeen","Eighteen","Nineteen"};
    static String[] stringsTwentyToNinety = new String[]{"Twenty","Thirty","Forty","Fifty","Sixty","Seventy",
            "Eighty","Ninety"};
    static String[] strings = new String[]{"Hundred","Thousand","Million","Billion"};

    //定义hashMap用于存储这些对应的整数值
    static HashMap<Integer,String> hashMapOneToNineteen = new HashMap<>();//记录1-19对应的英文字母，这些都是可以直接输出的
    static HashMap<Integer,String> hashMapTwentyToNinety = new HashMap<>();//记录20-90，这些需要进一步确定个位数字
    static HashMap<Integer,String> hashMapBig = new HashMap<>();//记录百，千，百万，十亿

    static {
        //初始化
        for (int i = 1; i <= 19; i++) {
            hashMapOneToNineteen.put(i,stringsOneToNineteen[i-1]);
        }
        for (int i = 2; i <= 9; i++) {
            hashMapTwentyToNinety.put(i * 10, stringsTwentyToNinety[i - 2]);
        }

        hashMapBig.put(100,strings[0]);
        hashMapBig.put(1000,strings[1]);
        hashMapBig.put(1000000,strings[2]);
        hashMapBig.put(1000000000,strings[3]);
    }
    public String numberToWords(int num) {

        //思路，将其分段表示，billion,million,thousand,hundred
        //每一个又可以划为一个更小的表示
        //如果是0，直接返回
        if (num == 0) return "Zero";

        //首先如果这个数是1-19，那么直接返回
        if (1 <= num && num <= 19) {
            return hashMapOneToNineteen.get(num);
        }

        //如果大于19小于100
        if (19 < num && num < 100) {
            //返回十位数+个位数
            if (num % 10 != 0){
                return hashMapTwentyToNinety.get(num - num % 10) + " " + numberToWords(num % 10);
            }else {
                return hashMapTwentyToNinety.get(num - num % 10);
            }

        }

        //如果在100-1000
        if (100 <= num && num < 1000) {
            //返回100的倍数+后两位
            if (num % 100 != 0){
                return numberToWords(num / 100) + " Hundred " + numberToWords(num % 100);
            }else {
                return numberToWords(num / 100) + " Hundred ";
            }

        }

        //如果在1000-1000000
        if (1000 <= num && num < 1000000) {
            //返回1000倍数+后三位
            if (num % 1000 != 0){
                return numberToWords(num / 1000) + " Thousand " + numberToWords(num % 1000);
            }else {
                return numberToWords(num / 1000) + " Thousand ";
            }
        }

        //如果在1000000-100000000
        if (1000000 <= num && num < 1000000000) {

            //返回1000000的倍数+后6位
            if (num % 1000000 != 0){
                return numberToWords(num / 1000000) + " Million " + numberToWords(num % 1000000);
            }else {
                return numberToWords(num / 1000000) + " Million ";
            }
        }

        if (num % 1000000000 != 0){
            return numberToWords(num / 1000000000) + " Billion " + numberToWords(num % 1000000000);
        }else {
            return numberToWords(num / 1000000000) + " Billion ";
        }

    }

    int[] digitals = new int[]{100,1000,1000000,1000000000};
    //程序简化
    public String numberToWords2(int num) {

        //思路，将其分段表示，billion,million,thousand,hundred
        //每一个又可以划为一个更小的表示
        //如果是0，直接返回
        if (num == 0) return "Zero";

        //首先如果这个数是1-19，那么直接返回
        if (1 <= num && num <= 19) {
            return hashMapOneToNineteen.get(num);
        }

        //如果大于19小于100
        if (19 < num && num < 100) {
            //返回十位数+个位数
            if (num % 10 != 0){
                return hashMapTwentyToNinety.get(num - num % 10) + " " + numberToWords(num % 10);
            }else {
                return hashMapTwentyToNinety.get(num - num % 10);
            }

        }

        for (int i = 0; i < digitals.length - 1; i++) {
            if (num>digitals[i] && digitals[i+1] > num){
                if (num % digitals[i] == 0){
                    return numberToWords2(num / digitals[i]) + " " + hashMapBig.get(digitals[i]);
                }else {
                    return numberToWords2(num / digitals[i]) + " " + hashMapBig.get(digitals[i]) + " " + numberToWords2(num % digitals[i]);
                }
            }
        }

        if (num % 1000000000 != 0){
            return numberToWords(num / 1000000000) + " Billion " + numberToWords(num % 1000000000);
        }else {
            return numberToWords(num / 1000000000) + " Billion ";
        }

    }

    public static void main(String[] args) {
        Leetcode273 leetcode273 = new Leetcode273();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n != 0){
            System.out.println(leetcode273.numberToWords2(n));
            n = in.nextInt();
        }

    }
}
