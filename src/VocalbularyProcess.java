import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.io.*;
import java.util.ArrayList;

/**
 * 对考研英语短语进行排序
 */

public class VocalbularyProcess {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Administrator\\Desktop\\java.txt");
        try {
            FileInputStream in = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            ArrayList<String> arrayList = new ArrayList<>();
            String string = "";
            while ((string = reader.readLine())!=null){
                if (string.length() == 0)continue;
                if (string.charAt(0)>='A' && string.charAt(0)<='Z') continue;
                arrayList.add(string);
            }
            String[] str= new String[arrayList.size()];
            arrayList.toArray(str);
            for(int i=str.length-1;i>=1;i--){
                for(int j=0;j<=i-1;j++){
                    if(str[j].compareTo(str[j+1])>0){
                        String temp = str[j];
                        str[j] = str[j+1];
                        str[j+1] = temp;
                    }
                }
            }

            char last = ' ';
            int sum = 0;
            FileOutputStream out = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\2.txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            for (String s:str
                 ) {
              if (s.length()>0){
                  if (s.charAt(0) == last){
                      System.out.println(s);
                      writer.write(s+"\n");
                      sum ++;
                  }

                  else {
                      System.out.println((s.charAt(0)+"").toUpperCase());
                      System.out.println(s);
                      writer.write("\n\n");
                      writer.write((s.charAt(0)+"").toUpperCase()+"\n");
                      writer.write(s+"\n");
                      last = s.charAt(0);
                  }
              }
            }
            System.out.println(sum);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
