package src.LeetCode;

public class Leetcode72 {

    /**给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

     你可以对一个单词进行如下三种操作：

     插入一个字符
     删除一个字符
     替换一个字符
     示例 1:

     输入: word1 = "horse", word2 = "ros"
     输出: 3
     解释:
     horse -> rorse (将 'h' 替换为 'r')
     rorse -> rose (删除 'r')
     rose -> ros (删除 'e')

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/edit-distance
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    //通过的代码
    static int[][] min ;
    public int minestDistance(String str1,String str2,int begin1,int begin2){
        //如果匹配完毕，递归结束
        if (str1.length() <= begin1 && str2.length() <= begin2) return 0;

        //如果str1已经没有字符了，那么只能够进行添加字符操作
        if (str1.length() <= begin1){
            return minestDistance(str1,str2,begin1,begin2+1)+1;
        }

        //如果str2已经没有字符了，那么只能进行删除字符操作
        if (str2.length() <= begin2){
            return  minestDistance(str1,str2,begin1+1,begin2)+1;
        }

        //如果当前字符是匹配的，那么不需要进行操作
        if (str1.charAt(begin1) == str2.charAt(begin2)) return minestDistance(str1,str2,begin1+1,begin2+1);
        //如果字符串没有匹配到最后
        else {
            //首先查找记录数组，看看是否已经计算过从当前位置开始让两个字符串相等的最小操作次数，如果已经计算过了，那就不需要在进行计算了
            if (min[begin1][begin2]== 0)
            {
                //添加一个字符
                int add = minestDistance(str1,str2,begin1,begin2+1);
                //删除一个字符
                int del = minestDistance(str1,str2,begin1+1,begin2);
                //修改一个字符
                int mod = minestDistance(str1,str2,begin1+1,begin2+1);

                //三种操作达到匹配的最小值
                int minest = Math.min(add,Math.min(del,mod));

                //将计算出的最小值放入记录数组
                min[begin1][begin2] = minest;
                return minest+1;
            }else
            return min[begin1][begin2]+1;
        }
    }

    public int minDistance(String word1, String word2) {
        //初始化记录数组
        min = new int[word1.length()+1][word2.length()+1];
       return minestDistance(word1,word2,0,0);

    }

    public static void main(String[] args) {
        Leetcode72 leetcode72 = new Leetcode72();
        System.out.println(leetcode72.minDistance("horse",
                "ros"));
    }


    //    public int minDistance(String word1, String word2) {
//
//        Queue<String> queueStr = new LinkedList<>();//保存操作后的字符串
//        Queue<Integer> queueInt = new LinkedList<>();//保存经过操作的次数和待匹配的下一个位置
//        queueStr.add(word1);
//        queueInt.add(0);
//        queueInt.add(0);
//        while (true){
//            String str = queueStr.poll();
//            int count = queueInt.poll();
//            int sit = queueInt.poll();
//            if (str.equals(word2)) return count;
//            //if (sit >str.length()) return count + word2.length() - str.length();//如果str没有字符了
//           // if (sit == word2.length()) return count + str.length() - word2.length();//如果word2已经没有字符了
//            while (sit<str.length()&&sit<word2.length()&&str.charAt(sit) == word2.charAt(sit)){
//                sit++;
//            }
//            if (sit>=str.length() && sit<word2.length()){//如果原始串字符位数不够，那么就添加
//                    queueStr.add(str + word2.charAt(sit));
//                    queueInt.add(count + 1);
//                    queueInt.add(sit+1);
//            }else if (sit>=word2.length()){//如果word2没有字符串匹配，那么就删除字符
//                queueStr.add(str.substring(0,str.length()-1));
//                queueInt.add(count +1);
//                queueInt.add(sit);
//            }else {
//                //替换
//                queueStr.add(str.substring(0,sit) + word2.charAt(sit) + str.substring(sit+1,str.length()));
//                queueInt.add(count +1);
//                queueInt.add(sit+1);
//                //删除
//                queueStr.add(str.substring(0,sit) +  str.substring(sit+1,str.length()));
//                queueInt.add(count +1);
//                queueInt.add(sit+1);
//                //添加
//                queueStr.add(str.substring(0,sit) + word2.charAt(sit) + str.substring(sit,str.length()));
//                queueInt.add(count +1);
//                queueInt.add(sit+1);
//            }
//
//        }
//    }


}
