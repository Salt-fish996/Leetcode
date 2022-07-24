package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        int n = arr.length;
        int sit = -1;
        //首先找到x应该放的位置i，arr[i]<=x,arr[i+1]>x
        for (int i = 0; i < n; i++) {
            if (arr[i] <= x){
                sit = i;
            }else break;
        }
        //向左向右找
        int left = sit;
        int right = sit + 1;
        int count = 0;//记录已经找到的数目
        while (count < k){
            if (left >= 0 && right<=n-1){
                if(Math.abs(arr[left] - x)<=Math.abs(arr[right] - x)){
                    arrayList.add(arr[left--]);
                    count++;
                }else {
                    count++;
                    arrayList.add(arr[right++]);
                }
            }else if (left >= 0){
                count++;
                arrayList.add(arr[left--]);
            }else if (right <= n-1){
                count++;
                arrayList.add(arr[right++]);
            }
        }
        Object[] temp = arrayList.toArray();
        Arrays.sort(temp);
        arrayList.clear();
        for (int i = 0; i < k; i++) {

            arrayList.add((int)temp[i]);
        }
        return arrayList;
    }

    //使用Collections.sort
    public List<Integer> findClosestElements2(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a, b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        Leetcode658 leetcode658 = new Leetcode658();
        int[] a = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(leetcode658.findClosestElements(a, 3, -1).toArray()));
    }
}

