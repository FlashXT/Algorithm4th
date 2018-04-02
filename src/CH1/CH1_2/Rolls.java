package CH1.CH1_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class Rolls {
    public static void main(String []args){
        StdOut.println("输入投掷次数：");
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        Counter heads=new Counter("heads");
        Counter tails=new Counter("tails");
        for(int t=0;t < T;t++)
            if(StdRandom.bernoulli(0.5))
                heads.increment();
            else tails.increment();
        StdOut.println("heads:"+heads.count);
        StdOut.println("tails:"+tails.count);
        int d = heads.tally()- tails.tally();
        StdOut.println("delta:"+Math.abs(d));

    }
    public void AAA(int k,double C){
        C=k+C;
    }
    public void AAA(double C,int k){
        C=k+C;
    }

}
