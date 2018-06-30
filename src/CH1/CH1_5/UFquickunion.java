package CH1.CH1_5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/***********************************************************************************
 * 简介：算法第四版1.5，union-find基本算法:quick-union,改进union()方法的效率；
 * 思路：    算法的重点是提高 union()方法的速度,它和 quick- find算法是互补的。它也基于相同
 *      的数据结构-以触点作为索引的 id[]数组,但赋予这些值的意义不同,我们需要用它们来定义更加
 *      复杂的结构。确切地说,每个触点所对应的 id[]元素都是同一个分量中的另一个触点的名称(也
 *      可能是它自己)---将这种联系称为链接。在实现 find()方法时,从给定的触点开始,由它的链接
 *      得到另一个触点,再由这个触点的链接到达第三个触点,如此继续跟随着链接直到到达一个根触点,
 *      即链接指向自己的触点(这样一个触点必然存在)。
 *          当且仅当分别由两个触点开始的这个过程到达,了同一个根触点时它们存在于同一个连通分量之
 *      中。为了保证这个过程的有效性,需要 union( p, q)来保证这一点。它的实现很简单:由 p和q的
 *      链接分别找到它们的根触点,然后只需将一个根触点链接到另一个即可将一个分量重命名为另一个分量，
 *      因此这个算法叫quick-union.
 *
 * Author：FlashXT;
 * Date:2018.6.30,Saturday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * *********************************************************************************/

public class UFquickunion extends UF {
    private static int[] id;       //分量id(以触点作为索引)
    private  int count;             //分量数量
    private  int linknum;           //连接数量

    public UFquickunion(int N){
        count = N;
        linknum = 0;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int find(int p) {

        while(id[p]!= p) p=id[p];
        return p;
    }

    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);

        if (proot == qroot) return;

        else {
            id[proot]=qroot;
            linknum++;
            count--;
        }

    }
    public static void main(String [] args){

        //解决动态连通性问题
        int [] point = In.readInts("src\\CH1\\Data\\tinyUF.txt");     //读取数据
        StdOut.print("触点数量："+point[0]+"\n");
        UFquickunion ufu = new UFquickunion(point[0]);  //初始化N个分量
        int num=1;
        while(num<point.length){

            int p = point[num];               //读取整数对
            int q = point[++num];
            num++;
            StdOut.print("("+p+","+q+"):");
            if(ufu.connected(p,q)){
                StdOut.println(" connected.");
                continue; //如果已经连通则忽略
            }
            ufu.union(p,q);                        //归并分量
            StdOut.print(" connecting..."+"\n");                 //打印连接

            for(int i = 0;i < id.length;i++){
                StdOut.printf("%-2d",i);
            }
            StdOut.println();
            for(int k:id)
                StdOut.printf("%-2d",k);
            StdOut.println();
        }
        StdOut.println("----------------------");
        for(int i = 0;i < id.length;i++){
            StdOut.printf("%-2d",i);
        }
        StdOut.println();
        for(int k:id)
            StdOut.printf("%-2d",k);
        StdOut.println();

        StdOut.print(ufu.count+" components; ");
        StdOut.println( ufu.linknum+" links");
    }
 }
