/*Algorithm4th,Binomial非递归版；直接利用组合公式计算阶乘，程序效率更高；
 * Author:FlashXT
 * Date:2018.3.31,Saturday；
 * */
package CH1.CH1_1;

import edu.princeton.cs.algs4.StdOut;
public class CH1_P27_Binomial3 {
    public static long count=0;
    public static double [][]M;
    public static void main(String [] args){
        StdOut.println("N\tk\tresult");

        StdOut.println("10\t5\t"+binomial(10,5,0.25));
    }
    public static double binomial(int N,int k,double p){
        int M=Factorial(N)/(Factorial(k)*Factorial(N-k));
        return M*Math.pow(p,k)*Math.pow(1-p,N-k);

    }

    public static int  Factorial(int N){
        int i=1;
        int product =1;
        while(i<=N) {
            product=product *i;
            i++;
        }
        return product;
    }

}
