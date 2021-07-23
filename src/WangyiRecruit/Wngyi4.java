package WangyiRecruit;

import java.util.HashMap;
import java.util.Scanner;

public class Wngyi4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            hashMap.put(arr[i],i);
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j < n; j++) {
                int temp;
                if ((temp  = hashMap.get(j))< i ){
                    count += Math.abs(temp-i);
                }
            }
        }
        System.out.println(count);
    }
}
