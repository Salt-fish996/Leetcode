package src;

import java.io.*;
import java.nio.charset.CharsetDecoder;
import java.util.*;

public class ScanFile {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入绝对路径：");
        String path = in.nextLine();
        System.out.print("请输入要扫描的文件后缀：");
        String lastPrefix = in.nextLine();
        File file = new File(path);
        Queue<File> queue = new LinkedList<>();
        queue.add(file);
        ArrayList<File> arrayList = new ArrayList<>();
        String str = "Leetcode";
//        //改名程序
//        while (!queue.isEmpty()){
//            File file1 = queue.poll();
//            if (file1.isDirectory()){
//                File[] files = file1.listFiles();//取出所有文件
//                //放入队列
//                queue.addAll(Arrays.asList(files));
//            }else {
//                //如果是文件而不是目录，那么对文件进行操作
//                //读取文件
//                BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file1)));
//                ArrayList<String> list = new ArrayList<>();
//                String context = null;
//                while ((context = in.readLine())!= null){
//                    list.add(context);
//                }
//                ArrayList<String> result = new ArrayList<>();
//                for (int i = 0; i < list.size(); i++) {
//
//                    result.add(list.get(i).replace(str,"LeetCode"));
//                }
//                in.close();//关闭输入流
//                //创建新文件
//                OutputStreamWriter writer = new OutputStreamWriter(new ObjectOutputStream(new FileOutputStream(file1)));
//                for (int i = 0; i < result.size(); i++) {
//                    writer.write(result.get(i) + "\n");
//                }
//                writer.close();
//                System.out.println("\n\n");
//                String name = file1.getName();
//                System.out.println("原始name:"+name);
//                if (name.length() > str.length() && name.substring(0,str.length()).equals(str)){
//                    name = "LeetCode" + name.substring(str.length());
//                }
//                file1.renameTo(new File(name));
//
//                System.out.println("修改name:"+name + "\n");
//            }
//        }

        int count = 0;
        int sum = 0;
        File result = new File("C:\\Users\\Administrator\\Desktop\\"+lastPrefix+".txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(result)));
        while (!queue.isEmpty()){
            File file1 = queue.poll();
            if (file1.isDirectory()){
                File[] files = file1.listFiles();
                queue.addAll(Arrays.asList(files));
            }else {
                //System.out.println(file1.getName());
                if ((file1.getAbsolutePath().contains("." + lastPrefix))){
                    System.out.println("文件名"+file1.getName());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file1),"utf-8"));
                    String s = "";
                    while ((s = reader.readLine())!=null){
                        if ((s.length() < 6 && s.length() > 0) || (s.length() > 6 && !s.substring(0,6).equals("import"))) {
                            System.out.println(s);
                            writer.write(sum+++":"+s+"\n");
                        }

                    }
                }
                count += file1.length();
            }
        }
        writer.flush();
        writer.close();
        System.out.println(count);
    }
}
