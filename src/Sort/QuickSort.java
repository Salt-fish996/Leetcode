package Sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//快速排序
public class QuickSort {

    public void quickSort(int[] arr,int begin,int end){
        if (begin >= end)
        {
            return;
        }

        int i = begin;
        int j = end;
        int standard = arr[begin];//选择基准点
        while (i < j){
            while (i<j && arr[j]>standard){
                j--;
            }
            arr[i] = arr[j];
            while (i<j && arr[i] <= standard){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = standard;

        quickSort(arr,begin,i-1);
        quickSort(arr,i+1,end);
    }

    public List<Integer> sortArray(int[] nums) {

        quickSort(nums,0,nums.length - 1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;

    }
    //字符串数字排序如：“123456”和“456”,降序
    public void quickSort(String[] arr,int begin,int end){
        if (begin >= end)
        {
            return;
        }

        int i = begin;
        int j = end;
        int standard = Integer.parseInt(arr[begin]);
        while (i < j){
            while (i<j && Integer.parseInt(arr[j])<standard){
                j--;
            }
            arr[i] = arr[j];
            while (i<j && Integer.parseInt(arr[i]) >= standard){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = ""+standard;

        quickSort(arr,begin,i-1);
        quickSort(arr,i+1,end);
    }



}
