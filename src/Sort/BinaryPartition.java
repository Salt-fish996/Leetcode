package Sort;

//二分法
public class BinaryPartition {
    public int binarySearch(int[] arr,int target,int begin,int end){
        if (begin == end){
            return begin;
        }
        if (begin > end) return -1;
        if (target < arr[begin]){
            return begin;
        }
        if (target >= arr[end]){
            return -1;
        }

        //首先找到中间元素
        int mid = (begin + end)/2;
        if (target < arr[mid]){
            return binarySearch(arr,target,begin,mid-1);
        }else {
            return binarySearch(arr,target,mid+1,end);
        }



    }
}
