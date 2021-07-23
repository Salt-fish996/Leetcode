package BaiDuCamups;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author hyy
 * @date 2020/3/14 18:44
 */
//100%
public class One {
    //首先遍历每个人喜欢的果汁数组，将其存入一个map中，Key是果汁种类，value是人数
    public int minestJuiceCups(int[] n, int k) {
        int result = 0;
        //初始化一个Map
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= k; i++) {
            map.put(i, 0);
        }
        //统计果汁数
        for (int i = 0; i < n.length; i++) {
            map.put(n[i], map.get(n[i]) + 1);
        }
        //遍历Map，由于是买一送一，因此只需要偶数/2，需求为奇数的时候+1/2
        for (int v:map.values()
             ) {
            if (v % 2== 0 ) {
                result += v / 2;
            } else {
                result += (v+1) / 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        One one = new One();
        System.out.println(one.minestJuiceCups(nums, k));
    }
}
