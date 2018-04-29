package CH1.CH1_4.DoublingRatioExperiments;

import CH1.CH1_4.SumProblem.ThreeSumBase;
import CH1.Tools.Stopwatch;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class DoublingRatio {

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
        double prev = timeTrial(125);
        StdOut.println("Scale\tCount\t\tRatio\n-------------------------");
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%-6d\t%-7.1f\t\t%-5.1f\n", N, time, time/prev);

            prev = time;
        }
    }
}

