package Sort;

//插入排序
public class InsertSort{

    //交换
    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //插入排序
    public void insertSort(int[] arr){

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    for (int k = i; k > j; k--) {
                        arr[k] = arr[k-1];
                    }
                    arr[j] = temp;
                    break;
                }
            }
        }
    }

    //二分搜索插入排序
    public void insertSortBinarSearch(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int low = 0;
            int high = i-1;
            while (low <= high){
                int mid = (low + high)/2;
                if (arr[i] < arr[mid]){
                    high = mid - 1;
                }else {
                    low = mid +1;
                }
            }
            int temp = arr[i];
            for (int k = i; k > high + 1; k--) {
                arr[k] = arr[k-1];
            }
            arr[high + 1] = temp;
        }
    }




}

