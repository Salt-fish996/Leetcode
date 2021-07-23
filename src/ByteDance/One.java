package ByteDance;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author hyy
 * @date 2020/3/15 18:48
 */
//50%
public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        //使用hashmap存储模型文件
        HashMap<String, TreeSet<String>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] temp = in.nextLine().split(" ");
            String user = temp[0];
            String file = temp[1];
            if (hashMap.containsKey(file)) {
                TreeSet<String> strings = hashMap.get(file);
                strings.add(user);
                hashMap.put(file, strings);
            } else {
                TreeSet<String> strings = new TreeSet<>();
                strings.add(user);
                hashMap.put(file, strings);
            }
        }

        for (String s:hashMap.keySet()
             ) {
            TreeSet<String > strings = hashMap.get(s);
            System.out.print(s);
            for (String s1:strings
                 ) {
                System.out.print(" ");
                System.out.print(s1);
            }
            System.out.println();
        }
    }
}
