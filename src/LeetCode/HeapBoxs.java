package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author hyy
 * @date 2020/3/20 12:12
 */
//通过
public class HeapBoxs {
    public void swap(int[][] box, int i, int j) {
        int[] ints = Arrays.copyOf(box[i], box[i].length);
        box[i] = Arrays.copyOf(box[j], box[j].length);
        box[j] = ints;
    }
    //按照长排列了以后进行dfs
    public int dfs(int[][] box, int now, HashMap<Integer, Integer> hashMap) {
        //剪枝
        if (hashMap.containsKey(now)) {
            return box[now][2] +hashMap.get(now);
        }

        //now表示当前的盒子，由于盒子是按照长来进行排列的，因此当i作为一层的时候，只能够i+j(1<=j)层作为上层
        int result = 0;
        for (int i = now + 1; i < box.length; i++) {
            if (box[i][0] < box[now][0] && box[i][1] < box[now][1] && box[i][2] < box[now][2]) {
                result = Math.max(result, dfs(box, i, hashMap));
            }
        }
        hashMap.put(now, result);
        return box[now][2] + result;
    }

    public int pileBox(int[][] box) {
        //分别按照长宽高进行排序
        //按照长排列
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box.length - i - 1; j++) {
                if (box[j][0] < box[j + 1][0]) {
                    swap(box, j, j + 1);
                }
            }
        }
       int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < box.length; i++) {
            result = Math.max(result, dfs(box,i,hashMap));
        }
        return result;
    }

    public static void main(String[] args) {
        HeapBoxs heapBoxs = new HeapBoxs();
        System.out.println(heapBoxs.pileBox(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}));
    }

}
