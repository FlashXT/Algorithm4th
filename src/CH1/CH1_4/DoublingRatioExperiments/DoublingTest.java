package CH1.CH1_4.DoublingRatioExperiments;

import CH1.CH1_4.Stopwatch;
import CH1.CH1_4.ThreeSum;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class DoublingTest {

    //为处理N个随机的六位整数的ThreeSum.count()计时
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch s = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return s.elapsedTime();
    }


    public static void main(String[] args) {
        //打印运行时间表格
        StdOut.println("Scale\tCount\n-------------");


         DrawGraph dg = new DrawGraph(0,0,15,5);
         dg.DrawXYLogBase();


        double timeprev = 0;
        for (int N = 1000; N < Integer.valueOf(args[0]); N += N) {
            double time = timeTrial(N);
            StdOut.printf("%-7f%5.1f\n", Math.log(N),Math.log(time));
            dg.DrawPoint(Math.log(N),Math.log(time));

            dg.DrawLine(Math.log(N/2),Math.log(timeprev),Math.log(N),Math.log(time));
            timeprev = time;

        } 
    } 
} 

