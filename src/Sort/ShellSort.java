package Sort;

//希尔排序，步长变化的插入排序
public class ShellSort {
    int[] pathLength = new int[]{1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,31,33,35,37,39,41,42,43};
    private void shellSort(int[] arr,int legth){
        for (int i = legth; i < arr.length; i++) {

            for (int j = i - i/legth*legth; j < i ; j= j+legth) {

                if (arr[i] < arr[j]){
                    int temp = arr[i];
                    for (int k = i; k > j ; k = k - legth) {
                        arr[k] = arr[k - legth];
                    }
                    arr[j] = temp;
                    break;
                }
            }
        }
    }
    public void shell(int[] arr){
//        int n = (arr.length+1)/2 - 1;
//        if (n>pathLength.length) n = pathLength.length - 1;
        int n = arr.length/2;
        for (int i = n; i > 0 ; i= i /2) {
            shellSort(arr,i);
        }
    }
}
