package CH1.CH1_4.DoublingRatioExperiments;

import CH1.CH1_4.SumProblem.ThreeSumBase;
import CH1.Tools.Stopwatch;
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
        int cnt = ThreeSumBase.count(a);
        return s.elapsedTime();
    }


    public static void main(String[] args) {
        //打印运行时间表格
        StdOut.println("Scale\tCount\n-------------");


         DrawGraph dg = new DrawGraph(0,0,2000,120);
         dg.DrawXYBase();


        double timeprev = 0;
        for (int N = 200; N < Integer.valueOf(args[0]); N += 100) {
            double time = timeTrial(N);
            StdOut.printf("%-7d%5.1f\n", N,time);
            dg.DrawPoint(N/10,time);

            dg.DrawLine((N-100)/10,timeprev,N/10,time);
            timeprev = time;

        } 
    } 
} 

