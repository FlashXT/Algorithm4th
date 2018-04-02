/*Algorithm4th,Binomial递归版，
 * Author:FlashXT
 * Date:2018.3.30,Friday
 * */
package CH1.CH1_1;


import edu.princeton.cs.algs4.StdOut;

public class CH1_P27_Binomial {
    public static double count=0;
    public static void main(String [] args){

        StdOut.println("N\tk\tcount");
        binomial(10,5,0.25);
        StdOut.println("10\t5\t"+count);
        binomial(20,5,0.25);
        StdOut.println("20\t5\t"+count);
        binomial(30,10,0.25);
        StdOut.println("30\t20\t"+count);
        binomial(30,20,0.25);
        StdOut.println("30\t30\t"+count);
    }
    public static double binomial(int N,int k,double p){
        count++;
        if(N == 0 && k == 0)   return 1.0;

        if(N < 0 || k < 0)     return 0.0;

        return (1.0 - p)*binomial(N-1,k,p)+p*binomial(N-1,k-1,p);
    }
}
