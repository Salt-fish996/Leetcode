package LeetCode;

public class Leetcode165 {
    public int parseInt(String s){
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result*10 + s.charAt(i) - '0';
        }

       // System.out.println(result);
        return result;
    }

    public int compareVersion(String version1, String version2) {

        version1 = version1.replace("\"","").replace(".","a");
        String[] str1  = version1.split("a");

        if (str1.length == 0){
            str1 = new String[]{version1.replace("\"","")};
        }

        version2 = version2.replace("\"","").replace(".","a");

        String[] str2 = version2.split("a");

        if (str2.length == 0){
            str2 = new String[]{version2.replace("\"","")};
        }
        version1 = "";
        version2 = "";

        int result = 0;
        if (str1.length > str2.length){
            for (int i = 0; i < str2.length; i++) {
                if (parseInt(str1[i]) > parseInt(str2[i])){
                    return 1;
                }else if (parseInt(str1[i]) < parseInt(str2[i])){
                    return -1;
                }
            }
            for (int i = str2.length ; i < str1.length; i++) {
                if (parseInt(str1[i]) > 0){
                    return 1;
                }
            }
            return 0;
        }else {

                for (int i = 0; i < str1.length; i++) {
                    if (parseInt(str1[i]) > parseInt(str2[i])){
                        return 1;
                    }else if (parseInt(str1[i]) < parseInt(str2[i])){
                        return -1;
                    }
                }
                for (int i = str1.length; i < str2.length; i++) {
                    if (parseInt(str2[i]) > 0){
                        return -1;
                    }
                }
                return 0;

        }
    }

    public static void main(String[] args) {
        Leetcode165 leetcode165 = new Leetcode165();
        String v1 = "\"01\"";
        String v2 ="\"1\"";
        System.out.println(leetcode165.compareVersion(v1,v2));
    }
}
