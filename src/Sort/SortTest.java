package Sort;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int n = 1000000;
        int[] arrays = new int[n];
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < n; i++) {
                arrays[i] = (int)(Math.random()*n + 1);
            }
            long start = 0;
            //测试堆排
            int[] arraysHeap = arrays.clone();
            HeapSort heapSort = new HeapSort();
            start = System.currentTimeMillis();
            heapSort.heapSort(arraysHeap,n);
            System.out.println("堆排时间："+(System.currentTimeMillis() - start));//+"  "+Arrays.toString(arraysHeap));

            //测试快排
            int[] arraysQuick = arrays.clone();
            QuickSort quickSort = new QuickSort();
            start = System.currentTimeMillis();
            quickSort.quickSort(arraysQuick,0,n-1);
            System.out.println("快排时间："+(System.currentTimeMillis() - start));//+"  "+Arrays.toString(arraysQuick));
            //System.out.println(Arrays.toString(arraysQuick));
            int last = 0;
            for (int i = 1; i < n; i++) {
                if (arraysQuick[i] < arraysQuick[i - 1]){
                    System.out.println("false");
                    System.out.println(Arrays.toString(arraysQuick));
                    break;
                }
            }
        }
//
//        //测试希尔排序
//        int[] arraysShell= arrays.clone();
//        ShellSort shellSort = new ShellSort();
//        start = System.currentTimeMillis();
//        shellSort.shell(arraysShell);
//        System.out.println("希尔排序时间："+(System.currentTimeMillis() - start));//+"  "+Arrays.toString(arraysShell));
//        //测试插入排序
//        int[] arraysInsert = arrays.clone();
//        InsertSort insertSort = new InsertSort();
//        start = System.currentTimeMillis();
//        insertSort.insertSort(arraysInsert);
//        System.out.println("插入排序时间："+(System.currentTimeMillis() - start));//+"  "+Arrays.toString(arraysInsert));
//
//        //二分插入排序
//        int[] arraysInsertBin = arrays.clone();
//        start = System.currentTimeMillis();
//        insertSort.insertSortBinarSearch(arraysInsertBin);
//        System.out.println("优化插入排序时间："+(System.currentTimeMillis() - start));//+"  "+Arrays.toString(arraysInsertBin));
//        //冒泡排序优化
//        int[] arraysBubbleOpt = arrays.clone();
//        BubbleSort bubbleSort = new BubbleSort();
//        start = System.currentTimeMillis();
//        bubbleSort.bubbleSortOpt(arraysBubbleOpt);
//        System.out.println("优化冒泡时间："+(System.currentTimeMillis() - start));//+"  "+Arrays.toString(arraysBubbleOpt));
//        //测试冒泡排序
//        int[] arraysBubble = arrays.clone();
//        start = System.currentTimeMillis();
//        bubbleSort.bubbleSort(arraysBubble);
//        System.out.println("普通冒泡时间："+(System.currentTimeMillis() - start));//+"  "+Arrays.toString(arraysBubble));


    }
}
