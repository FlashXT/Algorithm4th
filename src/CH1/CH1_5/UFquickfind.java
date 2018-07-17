package CH1.CH1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/********************************************************************************
 * 简介：算法第四版1.5，union-find基本算法:quick-find
 * Author：FlashXT;
 * Date:2018.6.30,Saturday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ******************************************************************************/

public class UFquickfind extends UF {

    private static int[] id;       //分量id(以触点作为索引)
    private  int count;             //分量数量
    private  int linknum;           //连接数量

    public UFquickfind(int N){
        count = N;
        linknum = 0;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) id[i] = qID;
            }
            linknum++;
            count--;
        }

    }
    public static void main(String [] args){

        //解决动态连通性问题
        int [] point = In.readInts("src\\CH1\\Data\\tinyUF1.5.1.txt");     //读取数据
        StdOut.print("触点数量："+point[0]+"\n");
        UFquickfind ufb = new UFquickfind(point[0]);  //初始化N个分量
        int num=1;
        while(num<point.length){

            int p = point[num];               //读取整数对
            int q = point[++num];
            num++;
            StdOut.print("("+p+","+q+"):");
            if(ufb.connected(p,q)){
                StdOut.println(" connected.");
                continue; //如果已经连通则忽略
            }
            ufb.union(p,q);                        //归并分量
            StdOut.print(" connecting..."+"\n");                 //打印连接
            ufb.Print(id);
        }
        StdOut.println("----------------------");
        ufb.Print(id);

        StdOut.print(ufb.count+" components; ");
        StdOut.println( ufb.linknum+" links");
    }
 }
