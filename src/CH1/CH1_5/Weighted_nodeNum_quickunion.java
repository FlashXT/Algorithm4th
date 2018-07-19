package CH1.CH1_5;

import CH1.Tools.Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************************
 * 简介：算法第四版1.5,quick-union改进；
 * 思路：    我们只需简单地修改 quick- union算法就能保证像这样的糟糕情况不再出现。与其在union()
 *      中随意将一棵树连接到另一棵树,我们现在会记录每一棵树的大小并总是将较小的树连接!到较大的树上。
 *      这项改动需要添加一个数组和一些代码来记录树中的节点数,但它能够大大改进算法的效率。我们将它称
 *      为加权 quick-union算法.
 * Author：FlashXT;
 * Date:2018.7.1,Sunday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ***********************************************************************************/

public class Weighted_nodeNum_quickunion {
    private static int[] id;       //父链接数组(由触点索引)
    private int[] sz;       //（由触点索引的）各个根节点对应的分量的大小
    private  int count;             //分量数量
    private  int linknum;           //连接数量

    public Weighted_nodeNum_quickunion(int N){
        count = N;
        linknum = 0;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
        { id[i] = i;sz[i]=1;}
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
            if(sz[proot] > sz[qroot]){ id[qroot] =proot;sz[proot]+=sz[qroot]; }
            else{ id[proot] = qroot;sz[qroot]+=sz[proot];}

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

    }
    public static void main(String [] args){

        Stopwatch time = new Stopwatch();
        //解决动态连通性问题
        int [] point = In.readInts("src\\CH1\\Data\\tinyUF1.5.1.txt");     //读取数据
        StdOut.print("触点数量："+point[0]+"\n");
        Weighted_nodeNum_quickunion wfu = new Weighted_nodeNum_quickunion(point[0]);  //初始化N个分量
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
