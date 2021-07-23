package CamupsRecruitTecent;

import java.util.*;

public class QuenueMin {
    /*题目描述:
    * 队伍中有n个顾客，从1到n标号。一开始，每个顾客在队伍中的位置是
    * i。每个顾客有两个属性ai和bi。每个顾客的不满意度等于ai*(j-1)+bi*(n-i)
    *
    *
    * 分析：
    * ai*(j-1)+bi*(n-j) = (ai-bi)*j-(ai-bi*n)
    * 由于ai-bi*n为固定值，∑(ai-bi)*j-(ai-bi*n) = ∑(ai-bi)*j-∑(ai-bi*n)
    * 因此只需要求∑(ai-bi)*j
    * 这里需要注意的是，由于ai-bi可能小于0，而当ai-bi<0时，越排在后面，这个愤怒值
    * 就会越小，因此应该吧ai-bi>0放在前面，把ai-bi<0放在后面
    * 因此对ai-bi采用分正负值得排序*/

    public int minQuenueValue(int[] a,int[] b){
        int n = a.length;
        int mz = 0;
        int mf = 0;
        int sum = 0;


        for (int i = 0; i < n; i++) {
            int temp = a[i] - b[i];
            if (temp >= 0){
                mz++;
            }else {
                mf++;
            }
            sum += -1*a[i] + b[i] * n;
        }
        int[] dz= new int[mz];
        int[] df = new int[mf];

        for (int i = 0; i < n; i++) {
            int temp = a[i] - b[i];
            if (temp >= 0){
                dz[--mz] = temp;
            }else {
                df[--mf] = temp;
            }
        }

        //System.out.println(Arrays.toString(dz));
        Arrays.sort(dz);//升序
        Arrays.sort(df);
        System.out.println(Arrays.toString(dz));
        System.out.println(Arrays.toString(df));

        int count1 = dz.length - 1;
        int count2 = df.length - 1;
        for (int i = 0; i < n; i++) {
            if (i < dz.length){
                if (count1 >=0){
                    System.out.println(dz[count1] + "  "+i);
                    sum += (i+1) * dz[count1--];
                }
            }else {
                if (count2>=0)
                {
                    System.out.println(df[count2] + "  "+i);
                    sum += (i+1) * df[count2--];
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        QuenueMin quenueMin = new QuenueMin();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        System.out.println(quenueMin.minQuenueValue(a,b));
    }



}

