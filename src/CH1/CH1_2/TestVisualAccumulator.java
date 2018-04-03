package CH1.CH1_2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Scanner;

public class TestVisualAccumulator {
    public static void main(String [] args){
        StdOut.printf("输入循环次数：");
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        VisualAccumulator a = new VisualAccumulator(T,1.0);

        for(int t = 0;t < T;t++)
            a.addDataValue(StdRandom.random());
        StdOut.println(a);
    }
}
