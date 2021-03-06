package CH1.CH1_4.SumProblem;

import CH1.Tools.Stopwatch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/*************************************************************************
 *  Compilation:  javac ThreeSum.java
 *  Execution:    java ThreeSum input.txt
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program with cubic running time. Read in N integers
 *  and counts the number of triples that sum to exactly 0
 *  (ignoring integer overflow).
 *
 *  % java ThreeSum 1Kints.txt 
 *  70
 *
 *  % java ThreeSum 2Kints.txt 
 *  528
 *
 *  % java ThreeSum 4Kints.txt 
 *  4039
 *
 *************************************************************************/

public class ThreeSumBase {

    // print distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static void main(String [] args){
        int count = 1;  int cnt = 0;
        System.out.println("Scale\tCount\t\tTime");
        System.out.println("--------------------------------");
        while(count <= 32){
            int [] data = In.readInts("src\\CH1\\Data\\"+count+"Kints.txt");
//            int [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8,4};
            Stopwatch timer = new Stopwatch();
            cnt = count(data);
            System.out.printf("%-2dK\t\t%-7d\t\t%.3fs\n",count,cnt,timer.elapsedTime());

            count*=2;
        }

    }

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        cnt++;
                       // StdOut.println(""+a[i]+","+a[j]+","+a[k]);
                    }
                }
            }
        }
        return cnt;
    }

} 
