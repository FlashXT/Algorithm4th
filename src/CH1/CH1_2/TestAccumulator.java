package CH1.CH1_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class TestAccumulator {
    public static void main(String [] args){
        StdOut.printf("输入循环次数：");
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        Accumulator a = new Accumulator();
        for(int t = 0;t < T;t++)
            a.addDataValue(StdRandom.random());
        StdOut.println(a);
    }
}
