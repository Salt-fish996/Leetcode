package src.LeetCode;


import java.util.*;

//这道题最大的特点是由于测试数据量很大，因此在最后计算结果String的时候，如果用String类型效率会很低，因此选择采用Stringbuffer，
//最小堆算法和优先队列的方式均可，但是最小堆算法的效率更高，花的时间更少
public class Leetcode451 {
    private void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //调整堆
    public void heapJustify(HashMap<Character,Integer> hashMap, char[] counts, int i, int n){
        int max = i;

        if (2*i + 1 < n && hashMap.get(counts[max]) > hashMap.get(counts[2*i +1])){
            max = 2*i + 1;
        }
        if (2*i + 2 <n && hashMap.get(counts[max]) > hashMap.get(counts[2*i + 2])){
            max = 2*i + 2;
        }
        if (max != i){

            swap(counts,i,max);
            heapJustify(hashMap,counts,max,n);
        }
    }

    //排序
    void heapSort(HashMap<Character,Integer> hashMap, char[] counts, int n){
        int k = counts.length;
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
    public void initHeap(HashMap<Character,Integer> hashMap,char[] counts,int n){
        for (int i = n-1; i >= 0; i--) {
            heapJustify(hashMap,counts,i,n);
        }
    }
    public String frequencySort(String s) {

        char[] characters = s.toCharArray();
//        HashMap<Character,String> characterStringHashMap = new HashMap<>();
        HashMap<Character,Integer> hashMap = new HashMap<>();//用于存储词频

        for (int i = 0; i < characters.length; i++) {
            if (hashMap.get(characters[i]) == null){

                hashMap.put(characters[i],1);
            }else {
                hashMap.put(characters[i],hashMap.get(characters[i]) + 1);
            }
//            if (characterStringHashMap.get(characters[i]) == null){
//                characterStringHashMap.put(characters[i],""+characters[i]);
//            }else {
//                characterStringHashMap.put(characters[i],characterStringHashMap.get(characters[i]) + characters[i]);
//            }
        }
        int n = hashMap.keySet().size();
        char[] chars = new char[n];
        int count = 0;
        for (char c:hashMap.keySet()
             ) {
            chars[count++] = c;
        }
        heapSort(hashMap,chars,n);
        StringBuffer result = new StringBuffer();
        for (int i = 0;i<n;i++) {
            int m = hashMap.get(chars[i]);
            for (int j = 0; j < m; j++) {
                result.append(chars[i]);
            }
        }

        return result.toString();
    }

    //使用优先队列
    public String frequencySort2(String s) {

        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        HashMap<Character,Integer> hashMap = new HashMap<>();//用于存储词频
        //HashMap<Character,StringBuffer> hashMap1 = new HashMap<>();

        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((o1,o2)->{
            return hashMap.get(o2) - hashMap.get(o1);
        });

        for (int i = 0; i < characters.length; i++) {
            if (hashMap.get(characters[i]) == null){
                hashMap.put(characters[i],1);
            }else {
                hashMap.put(characters[i],hashMap.get(characters[i]) + 1);
            }
           // hashMap1.put(characters[i],hashMap1.get((characters[i])) == null?new StringBuffer(""+characters[i]):hashMap1.get(characters[i]).append(characters[i]));

        }

        priorityQueue.addAll(hashMap.keySet());
        StringBuffer result = new StringBuffer();
        while (!priorityQueue.isEmpty()){
            char c1 = priorityQueue.poll();
            int n = hashMap.get(c1);
            for (int i = 0; i < n; i++) {
                result.append(c1);
            }
        }
        return result.toString();
    }




    public static void main(String[] args) {
        Leetcode451 leetcode451 = new Leetcode451();
        long start = System.currentTimeMillis();
        System.out.println(leetcode451.frequencySort("abbbccdjijisddainjdijnaivninvadinvdjndvjinvdadadsdsd")+" 时间："+(System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(leetcode451.frequencySort2("abbbccdjijisddainjdijnaivninvadinvdjndvjinvdadadsdsd")+" 时间："+(System.currentTimeMillis() - start));
        //String效率测试
        StringBuffer s1 = new StringBuffer();
        String s2 = "";
        StringBuilder s3 = new StringBuilder();

        int n = 1000000;
        //StringBuffer测试
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            s1.append("a");
        }
        System.out.println("StringBuffer时间："+(System.currentTimeMillis() - start));

        //StringBuildre测试
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            s3.append( "a");
        }
        System.out.println("StringBuilder时间："+(System.currentTimeMillis() - start));


        //StringBuffer测试
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            s2 += "a";
        }
        System.out.println("String时间："+(System.currentTimeMillis() - start));

    }
}
