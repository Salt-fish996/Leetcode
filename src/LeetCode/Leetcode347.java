package src.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode347 {
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //调整堆
    public void heapJustify(HashMap<Integer,Integer> hashMap, int[] counts, int i, int n){
        int max = i;

        if (2*i + 1 < n && hashMap.get(counts[max]) < hashMap.get(counts[2*i +1])){
            max = 2*i + 1;
        }
        if (2*i + 2 <n && hashMap.get(counts[max]) < hashMap.get(counts[2*i + 2])){
            max = 2*i + 2;
        }
        if (max != i){
            swap(counts,i,max);
            heapJustify(hashMap,counts,max,n);
        }
    }

    //排序
    void heapSort(HashMap<Integer,Integer> hashMap,int[] counts,int n,int k){
        int m = k;
        initHeap(hashMap,counts,n);
        while (k > 0){
            swap(counts,0,n-(m-k)-1);
            heapJustify(hashMap,counts,0,n-(m-k)-1);
            //System.out.println(counts[n-m+k-1]);
            k--;

        }
    }
    //初始化堆
    public void initHeap(HashMap<Integer,Integer> hashMap,int[] counts,int n){
        for (int i = n-1; i >= 0; i--) {
            heapJustify(hashMap,counts,i,n);
        }
    }
    //大顶堆+hashMap
    public List<Integer> topKFrequent(int[] nums, int k) {

        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hashMap.get(nums[i]) == null){
                hashMap.put(nums[i],1);
            }else {
                hashMap.put(nums[i],hashMap.get(nums[i]) + 1);
            }
        }
        int length = hashMap.values().size();
        int[] values = new int[length];
        int countSum = 0;
        for (Integer o:hashMap.keySet()
             ) {
            values[countSum++] = o;
        }
        heapSort(hashMap,values,values.length,k);
        for (int i = 0; i < k; i++) {
            list.add((Integer)values[values.length-i-1]);
            System.out.println(values[values.length-i-1]);
        }
        return list;

    }

    public static void main(String[] args) {
        Leetcode347 leetcode347 = new Leetcode347();
        int[] a = {1,1,1,2,2,3,3,3,3};
        System.out.println(Arrays.toString(leetcode347.topKFrequent(a, 2).toArray()));
    }
}
