package CamupsRecruitTecent;

import java.util.*;

/**
 * @author hyy
 * @date 2019/8/17 19:57
 */
public class TecentTest {

/*    public String iterto(String s,int begin, int end){
        String temp = "";
        int count = 0;
        *//*for (int i = begin; i < end; i++) {
            if (s.charAt(i)>='A' && s.charAt(i) <= 'Z'){
                temp += s.charAt(i);
            }else
            if (s.charAt(i) == '['){
                int tempend = 0;
                int j  = end-1;
                for (; j >= begin; j--) {
                    if (s.charAt(j) == ']'){
                        break;
                    }
                }
                while (s.charAt(i++) != '|')
                if (s.charAt(i)>='0' && s.charAt(i)<='9'){
                    count = count*10 + s.charAt(i)-'0';
                }
                String tempit = iterto(s,i,j);
                for (int k = 0; k < count; k++) {
                    temp+= tempit;
                }
                i = j;

            }*//*

        }
        return "";}
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        TecentTest tecentTest = new TecentTest();
        System.out.println(tecentTest.iterto(s,0,s.length()));


    }*/
public static void main(String[] args) {
    HashMap<String,String> hashMap = new HashMap<>();
    HashSet<String> hashSet = new HashSet<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();
    hashMap.put("1","a");
    hashMap.put("2","b");
    hashMap.put("1","2");
    hashSet.add("1");
    hashSet.add("2");
    hashSet.add("3");

    Integer a = 10, b = 10, c = 150,d = 150;
    System.out.println(a == b);
    System.out.println(c == d);
    Integer e = new Integer(150);
    int f = 150;
    System.out.println(e == f);

}
}
