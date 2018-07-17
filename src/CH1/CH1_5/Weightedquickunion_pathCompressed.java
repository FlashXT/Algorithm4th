package CH1.CH1_5;

import CH1.Tools.Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*************************************************************************************
 * 简介：算法第四版1.5,Weightedquick-union改进；
 * 思路：   可以找到一种能够保证在常数时间内完成各种操作的算法吗?这个问题非常困难并且困扰,了研究者们
 *     许多年。在寻找答案的过程中,大家研究了 quick- union算法和加权 quick- union算法的各种变体。
 *     例如,下面这种路径压缩方法很容易实现。理想情况下,我们希望每个节点都直接链接,,到它的根节点上,但
 *     我们又不想像 quick- find算法那样通过修改大量链接做到这一点。我们接近这,种理想状态的方式很简
 *     单,就是在检查节点的同时将它们直接链接到到根节点。我们所得到的结果是几乎完全扁平化的树,它和
 *     quick- find算法理想情况下所得到的树非常接近。这种方法即简单又有效,但在实际情况下已经不太可能
 *     对加权 quick- union算法继续进行任何改进了(请见练习1.5.24)。对该情况的理论研究结果非常复杂也
 *     值得我们注意:路径压缩的加权 quick- union算法是最优的算法,但并非所有操作都能在常数时间内完成。
 *     也就是说,使用路径压缩的加权 quick- union算法的每个操作在在最坏情况下(即均摊后)都不是常数级别
 *     的，而且不存在其他算法能够保证unoin-find算法的所有操作在均摊后都是常数级别的（在cell-probe
 *     模型下）。使用路径压缩的加权quick-union算法已经是对于这个问题能够给出的最优解了。
 * Author：FlashXT;
 * Date:2018.7.1,Sunday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ***********************************************************************************/

public class Weightedquickunion_pathCompressed {
    private static int[] id;        //父链接数组(由触点索引)
    private int[] sz;               //（由触点索引的）各个根节点对应的分量的大小
    private  int count;             //分量数量
    private  int linknum;           //连接数量

    public Weightedquickunion_pathCompressed(int N){
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
        int temp=p;
        int next;
        while( p != id[p]) p=id[p];
        while(temp !=p){
            next=id[temp];
            id[temp]=p;
            temp=next;
        }
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
    }

    public static void main(String [] args){

        Stopwatch time = new Stopwatch();
        //解决动态连通性问题
        int [] point = In.readInts("src\\CH1\\Data\\tinyUF.txt");     //读取数据
        StdOut.print("触点数量："+point[0]+"\n");
        Weightedquickunion_pathCompressed wfupc = new Weightedquickunion_pathCompressed(point[0]);  //初始化N个分量
        int num=1;
        while(num<point.length){

            int p = point[num];               //读取整数对
            int q = point[++num];
            num++;
            StdOut.print("("+p+","+q+"):");
            if(wfupc.connected(p,q)){
                StdOut.println(" connected.");
                continue; //如果已经连通则忽略
            }
            wfupc.union(p,q);                        //归并分量
            StdOut.print(" connecting..."+"\n");                 //打印连接
            wfupc.Print();
        }
        StdOut.println("----------------------");
        wfupc.Print();

        StdOut.print(wfupc.count+" components; ");
        StdOut.println( wfupc.linknum+" links");
        StdOut.println(time.elapsedTime()+"s");
    }
 }
