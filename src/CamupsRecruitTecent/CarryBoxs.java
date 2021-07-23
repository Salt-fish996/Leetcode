package CamupsRecruitTecent;

import java.util.Scanner;

public class CarryBoxs {
    /*搬箱子；每一个房间有m个箱子，m不确定
    * 每个房间的箱子用boxs[i]来表示
    * 每个房间的人数用peoples[i]表示
    * 假设现在一共有n个工人，工人只能够一个房间一个房间的
    * 向下走，每次可以选择向下一个房间走或者搬走一个箱子然后
    * 留在原房间
    * 初始思路(不保证正确，每次从boxs[boxs.length-]开始遍历
    * 如果这个房间现在有boxs[i]个箱子，有peoples[i]个工人
    * 如果boxs[i]<v，那么设置boxs[i]=0,peoples[i]=boxs[i],peoples[i+1]+=peoples[i]-boxs[i]
    * 如果boxs[i]>v,那么设置boxs[i]=boxs[i]-peoples[i],人数不变*/

    public int minestTime(int[] boxs,int n){
        int[] peoples = new int[boxs.length+1];
        int costTime = 1;
        peoples[0] = n;

        while (true){

            int countZero = 0;//统计没有箱子的房间数
            for (int i = boxs.length-1; i >= 0; i--) {
                if (boxs[i] >= peoples[i])//如果搬运人数小于箱子数目
                {
                    boxs[i] = boxs[i] - peoples[i];

                }else{
                    int temp = peoples[i];
                    peoples[i] = boxs[i];
                    peoples[i+1] += temp - boxs[i];
                    boxs[i] = 0;
                }
                if (boxs[i] == 0) countZero++;
            }

            System.out.print("箱子数：");
            for (int i = 0; i < boxs.length; i++) {
                System.out.print(boxs[i] + " ");
            }

            System.out.print("人数：");
            for (int i = 0; i < boxs.length; i++) {
                System.out.print(peoples[i] + " ");
            }
            System.out.println();


            if (countZero == boxs.length)//如果每个房间箱子数目都是0，那么程序结束
            {
                return costTime + 1;
            }
            costTime++;

        }
    }


    public static void main(String[] args) {
        CarryBoxs carryBoxs = new CarryBoxs();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] boxs = new int[n];
        for (int i = 0; i < n; i++) {
            boxs[i] = in.nextInt();
        }

        System.out.println(carryBoxs.minestTime(boxs,m));

    }
}
