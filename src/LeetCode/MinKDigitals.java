package src.LeetCode;

import java.util.Arrays;

/**
 * @author hyy
 * @date 2020/3/20 9:00
 */
public class MinKDigitals {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void heapAdjust(int[] arr, int i, int n) {
        //i的子节点是2i+1和2*i+2
        int temp = i;
        if (2 * i + 1 < n && arr[temp] > arr[2 * i + 1]) {
            temp = 2 * i + 1;
        }
        if (2 * i + 2 < n && arr[temp] > arr[2 * i + 2]) {
            temp = 2 * i + 2;
        }
        if (temp != i) {
            swap(arr, temp, i);
            heapAdjust(arr, temp,n);
        }
    }
    public void headBuild(int[] arr) {
        int n = arr.length;
        //最后一个结点是n-1位置上，他的父节点是(n-2)/2
        for (int i = (arr.length)/2 - 1; i >= 0 ; i--) {
            heapAdjust(arr, i, arr.length);
        }
    }
    //找到最小的K个数
    public int[] heapSort(int[] arr, int k) {
        headBuild(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[0];
            swap(arr, 0, arr.length - 1 - i);
            heapAdjust(arr, 0, arr.length - i - 1);
        }
        return result;
    }
    //使用最小堆
    public int[] getLeastNumbers(int[] arr, int k) {
        return heapSort(arr, k);
    }

    public static void main(String[] args) {
        MinKDigitals minKDigitals = new MinKDigitals();
        System.out.println(Arrays.toString(minKDigitals.getLeastNumbers(new int[]{3, 2, 1,-5,9,3,8,-1}, 2)));
    }
}
