package CH1.CH1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/********************************************************************************
 * 简介：算法第四版1.5，union-find基本算法
 *
 *      ----------------------------union-find算法的API--------------------------
 *      public class UF
 *      ------------------------------------------------------------------------
 *                 UF(int N)                  以整数标识(0~N-1)初始化N个触点
 *          void   union(int p,int q)         在p和q之间添加一条连接
 *           int   find(int p)                p所在的分量额标识符(0~N-1)
 *       boolean   connected(int p,int q)    如果p和q存在于同一个分量中则返回true
 *           int   count()                    连通分量的数量
 *      ------------------------------------------------------------------------
 * Author：FlashXT;
 * Date:2018.6.7,Thursday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ******************************************************************************/

public class UnionFindBase {

    private static int[] id;
    private int count;

    public UnionFindBase(int N){
        count = N;
        id = new int[N];
        for(int i = 0; i < N;i++)
            id[i] = i;
    }

    public int count(){
        return count;
    }
    public boolean connected(int p,int q){
        return find(p)==find(q);
    }
    public int find(int p){
        return id[p];
    }
    public void union(int p,int q){
        int pID = id[p];
        int qID = id[q];

        if(pID == qID) return ;

        else{
            for(int i = 0; i < id.length;i++){
                if(id[i] == pID) id[i] = qID;
            }
            count --;
        }

    }

    public static void main(String [] args){
        //解决由StdIn得到的动态连通性问题
        StdOut.print("请输入触点数量：");
        int N = StdIn.readInt();                   //读取触点数量
        UnionFindBase ufb = new UnionFindBase(N);  //初始化N个分量

        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();               //读取整数对
            int q = StdIn.readInt();
            if(ufb.connected(p,q)) continue;       //如果已经连通则忽略
            ufb.union(p,q);                        //归并分量
            StdOut.print(p+" "+q+"\n");                 //打印连接

            for(int k:id){
                StdOut.printf("%-2d",k);
            }
        }
        StdOut.println(ufb.count()+"components");
    }
 }
