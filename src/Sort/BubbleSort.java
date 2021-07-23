package Sort;

//冒泡排序
public class BubbleSort {
    //交换
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //冒泡排序
    public void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i -1; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }
    //冒泡排序优化
    public void bubbleSortOpt(int[] arr){
        int n = arr.length;
        boolean flag = true;//用于标记一次遍历有没有交换，如果没有直接退出
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < n - i -1; j++) {
                if (arr[j] > arr[j+1]){
                    flag = false;
                    swap(arr,j,j+1);
                }
            }
            if (flag){
                return;
            }
        }
    }

}
