package CH1.CH1_5;

import CH1.Tools.Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************************
 * 简介：算法第四版1.5,CH1.5.14；
 * 思路：加权 quick-union算法,与书中的加权不同的是，权重采用数的高度，而不是节点数目；
 * Author：FlashXT;
 * Date:2018.7.1,Sunday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ***********************************************************************************/

public class Weighted_high_quickunion {
    private static int[] id;       //父链接数组(由触点索引)
    private int[] sz;       //（由触点索引的）各个根节点对应的分量的大小
    private  int count;             //分量数量
    private  int linknum;           //连接数量

    public Weighted_high_quickunion(int N){
        count = N;
        linknum = 0;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
        { id[i] = i;sz[i]=0;}
    }

    public int count(){return count;}
    public boolean connected(int p,int q){
        return find(p) == find(q);
    }
    public int find(int p){
        //跟随链接找到根节点
        while( p != id[p]) p=id[p];
        return p;
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);

        if (proot == qroot) return;
        //将小树的根节点连接到大树的根节点上
        else {
            if(sz[proot] > sz[qroot]){ id[qroot] =proot;sz[proot] = sz[proot]>sz[qroot]+1 ? sz[proot]:sz[qroot]+1; }
            else{ id[proot] = qroot;sz[qroot] = sz[qroot]>sz[proot]+1 ? sz[qroot]:sz[proot]+1;}

            linknum++;
            count--;
        }

    }

    public void Print(){
        for(int i = 0;i < id.length;i++){
            StdOut.printf("%-2d",i);
        }
        StdOut.println();
        for(int k:id)
            StdOut.printf("%-2d",k);
        StdOut.println();
        StdOut.println("----------------------");
        for(int i = 0;i < id.length;i++){
            StdOut.printf("%-2d",i);
        }
        StdOut.println();
        for(int k:sz)
            StdOut.printf("%-2d",k);
        StdOut.println("\n======================");
    }
    public static void main(String [] args){

        Stopwatch time = new Stopwatch();
        //解决动态连通性问题
        int [] point = In.readInts("src\\CH1\\Data\\tinyUF1.5.1.txt");     //读取数据
        StdOut.print("触点数量："+point[0]+"\n");
        Weighted_high_quickunion wfu = new Weighted_high_quickunion(point[0]);  //初始化N个分量
        int num=1;
        while(num<point.length){

            int p = point[num];               //读取整数对
            int q = point[++num];
            num++;
            StdOut.print("("+p+","+q+"):");
            if(wfu.connected(p,q)){
                StdOut.println(" connected.");
                continue; //如果已经连通则忽略
            }
            wfu.union(p,q);                        //归并分量
            StdOut.print(" connecting..."+"\n");                 //打印连接
            wfu.Print();

        }
        StdOut.println("----------------------");
        wfu.Print();

        StdOut.print(wfu.count+" components; ");
        StdOut.println( wfu.linknum+" links");
        StdOut.println(time.elapsedTime()+"s");
    }
 }
