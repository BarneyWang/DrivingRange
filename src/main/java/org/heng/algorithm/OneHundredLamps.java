package org.heng.algorithm;

/**
 *
 *
 * 题目：50个灯，有50个按钮，编号为1，2，3……50.刚开始灯全部是熄的，
 * 现在依次按按钮，每次按到按钮i，i的倍数编号的灯就变一下状态，问到最后开了几盏灯。

  百度上搜到了原题目：教室里有编号为1~50的电灯50盏，现全部处于关闭状态。六（一）班则好有50名同学，
  现依次进入教室，第一个同学将所有电灯都拉一下，第二个同学将编号为2的倍数的电灯各拉一下，
  第三个同学将编号为3的倍数的电灯各拉一下……，
  依此类推，直到最后一个同学操作完毕后，教室里共有几盏灯是亮着的？
 * Created by wangdi5 on 2015/5/24.
 */
public class OneHundredLamps {

    private static  int lampCount = 100;





    public static void main(String[] args) {

        int[] a = new int[lampCount+1];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = 0;
        }
        //外层，学生序号
        for (int i = 1; i <= lampCount; i++)
        {
            //内层，拉灯
            for (int j = 1; i*j <= lampCount; j++)
            {
                //灯状态改变
                a[i * j] = Math.abs(a[i * j] - 1);
            }

        }


        //打印亮着的灯的编号和亮灯总数
        int count = 0;
        for (int i = 1; i <= lampCount; i++)
        {
            System.out.println(String.format("第%s盏  亮%s",i,a[i]));
            if (a[i]==1)
            {
                System.out.println(String.format("第%s盏",i));
                count++;
            }
        }

    }
}
