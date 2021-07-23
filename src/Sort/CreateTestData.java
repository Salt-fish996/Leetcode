package Sort;

import java.io.*;
import java.util.*;

public class CreateTestData {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        HashSet<String> hashSet = new HashSet<>();
        HashMap<String,Integer> counts = new HashMap<>();//记录最大数出现次数
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1) - Integer.parseInt(o2);
            }
        });
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        int count = 500000;
        long c = 0;
        QuickSort quickSort = new QuickSort();
        while (count-->0 ){
            String[] s = in.readLine().split("  ");
            quickSort.quickSort(s,0,s.length-1);
            //System.out.println(Arrays.toString(s));
            for (int i = 0; i < 10; i++) {
                c++;
                //System.out.println(s[s.length - 1 -i]);
                if (!hashSet.contains(s[i])){
                    priorityQueue.add(s[i]);
                    hashSet.add(s[i]);
                    counts.put(s[i],1);
                    if (priorityQueue.size() >10){
                        String temp = priorityQueue.poll();
                        hashSet.remove(temp);
                        counts.remove(temp);
                    }
                }else {
                    counts.put(s[i],counts.get(s[i]) + 1);
                }
            }
        }
        in.close();
        while (!priorityQueue.isEmpty()){
            String s = priorityQueue.poll();
            System.out.println(s+"  "+counts.get(s));
        }
        System.out.println(c);
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
//       long n = 100000000l/2;
//       int count = 100;
//        for (long i = 0; i < n; i++) {
//            count --;
//            out.write(""+(long)(Math.random()*100000+1)+"  ");
//            if (count ==0){
//                count = 100;
//                out.write("\n");
//            }
//        }
//        out.close();

    }
}
