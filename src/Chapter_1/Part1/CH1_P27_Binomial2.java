/*Algorithm4th,Binomial递归改进版，用数组保存计算过的组合值，先抓住减少调用次数；提高运行效率；
 * Author:FlashXT
 * Date:2018.3.31,Saturday；
 * */
package Chapter_1.Part1;

import edu.princeton.cs.algs4.StdOut;

public class CH1_P27_Binomial2 {
    public static long count=0;
    public static double [][]M;
    public static void main(String [] args){
        StdOut.println("N\tk\tcount");
        binomial(10,5,0.25);
        StdOut.println("10\t5\t"+count);
        //StdOut.println("10\t5\t"+binomial(10,5,0.25));

        binomial(20,5,0.25);
        StdOut.println("20\t5\t"+count);
        binomial(30,10,0.25);
        StdOut.println("30\t20\t"+count);
        binomial(30,20,0.25);
        StdOut.println("30\t30\t"+count);
    }

    public static double Binomial(int N,int k,double p){
        count++;
        if(N == 0 && k == 0) { M[N][k]=1.0; return M[N][k];}
        if(N < 0 || k < 0)   {              return 0.0;    }
        if(M[N][k]==-1)
            M[N][k] = (1.0 - p)*Binomial(N-1,k,p)+p*Binomial(N-1,k-1,p);

        return M[N][k];
    }
    public static double binomial(int N,int k,double p){
        M=new double[N+1][k+1];
        for(int i=0;i<M.length;i++)
            for(int j=0;j<M[i].length;j++)
                M[i][j]=-1;
        return Binomial(N,k,p);
    }
}
