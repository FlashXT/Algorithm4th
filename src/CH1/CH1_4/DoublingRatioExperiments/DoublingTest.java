package CH1.CH1_4.DoublingRatioExperiments;

import CH1.CH1_4.Stopwatch;
import CH1.CH1_4.ThreeSum;

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
        DrawGraph.DrawXYBase();
        double x = 0;
        for (int N = 256; N < Integer.valueOf(args[0]); N += N) {
            double time = timeTrial(N);
            StdOut.printf("%-7d%5.1fs\n", N, time);
            DrawGraph.DrawPoint(N,time);

            DrawGraph.DrawLine(N/2,x,N,time);
            x = time;

        } 
    } 
} 

