package Sort;

//堆排序
public class HeapSort {
    //交换
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //调整堆
    private void heapAdjust(int[] arr,int i,int n){
        int max = i;
        if (2*i + 1 < n && arr[2*i + 1] > arr[max]){
            max = 2*i + 1;
        }

        if (2*i + 2 < n && arr[2*i + 2] > arr[max]){
            max = 2*i + 2;
        }

        if (max != i){
            swap(arr,i,max);
            heapAdjust(arr,max,n);
        }
    }

    //初始化堆
    private void initHeap(int[] arr,int n){
        for (int i = n-1; i >= 0; i--) {
            heapAdjust(arr,i,n);
        }
    }

    //堆排序
    public void heapSort(int[] arr, int n){
        //初始化堆
        initHeap(arr,n);
        //开始排序
        while (n > 0){
            swap(arr,0,n-1);
            heapAdjust(arr,0,n - 1);
            n--;
        }
    }
}
