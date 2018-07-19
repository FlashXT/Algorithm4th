package CH1.CH1_5;

import CH1.Tools.Graph.DrawXYAxis;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.awt.*;

/********************************************************************************
 * 简介：算法第四版1.5，union-find基本算法:quick-find（同课后CH1.5.7题）
 * Author：FlashXT;
 * Date:2018.6.30,Saturday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ******************************************************************************/

public class QFSharingCostGraph extends UF {

    private static int[] id;       //分量id(以触点作为索引)
    private  int count;             //分量数量
    private  int linknum;           //连接数量

    private  int arrayAccessNum = 0; //访问数组ID的次数

    public QFSharingCostGraph(int N){
        count = N;
        linknum = 0;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int find(int p) {

        arrayAccessNum++;
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) {
                    arrayAccessNum++;
                    id[i] = qID;
                }
            }
            arrayAccessNum+= id.length;
            linknum++;
            count--;
        }

    }
    public static void main(String [] args){

        //解决动态连通性问题
        int [] point = In.readInts("src\\CH1\\Data\\mediumUF.txt");     //读取数据
        StdOut.print("触点数量："+point[0]+"\n");
        QFSharingCostGraph qfs = new QFSharingCostGraph(point[0]);  //初始化N个分量
        int num=1;

        DrawXYAxis xyAxis = new DrawXYAxis(1300,2000);
        int temp = qfs.arrayAccessNum;
        int lastNum = 0;
        StdOut.println(point.length);
        while((num+1)/2<=(point.length-1)/2){



            temp = qfs.arrayAccessNum-lastNum;
            lastNum = qfs.arrayAccessNum;
            int p = point[num];               //读取整数对
            int q = point[num+1];


//            qfs.arrayAccessNum+=2;
            if(qfs.connected(p,q)){
                //绘制每次循环访问数组的次数
//            xyAxis.drawPoint((num+1)/2,temp);
//            StdOut.println((num+1)/2+"---"+temp);
                //绘制循环访问数组的总次数
//            xyAxis.drawPoint((num+1)/2,qfs.arrayAccessNum);
//            StdOut.println((num+1)/2+"---"+qfs.arrayAccessNum);
                //绘制访问数组次数的累计平均
                xyAxis.drawPoint((num+1)/2,qfs.arrayAccessNum/((num+1)/2));
                StdOut.println((num+1)/2+"---"+qfs.arrayAccessNum/((num+1)/2));

                num+=2;
                continue; //如果已经连通则忽略
            }
            qfs.union(p,q);                        //归并分量
            //绘制每次循环访问数组的次数
//            xyAxis.drawPoint((num+1)/2,temp);
//            StdOut.println((num+1)/2+"---"+temp);
            //绘制循环访问数组的总次数
//            xyAxis.drawPoint((num+1)/2,qfs.arrayAccessNum);
//            StdOut.println((num+1)/2+"---"+qfs.arrayAccessNum);
            //绘制访问数组次数的累计平均
            xyAxis.drawPoint((num+1)/2,qfs.arrayAccessNum/((num+1)/2));
            StdOut.println((num+1)/2+"---"+qfs.arrayAccessNum/((num+1)/2));
            num+=2;

        }
        StdOut.println("\n----------------------");
        StdOut.print(qfs.count+" components; ");
        StdOut.println( qfs.linknum+" links");
    }
}
