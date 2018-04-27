package CH1.CH1_4.SumProblem; /*************************************************************************
 *  Compilation:  javac ThreeSumFast.java
 *  Execution:    java ThreeSumFast input.txt
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program with N^2 log N running time. Read in N integers
 *  and counts the number of triples that sum to exactly 0.
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *     - doesn't handle case when input has duplicates
 *
 *
 *  % java ThreeSumFast 1Kints.txt
 *  70
 *  
 *  % java ThreeSumFast 2Kints.txt
 *  528
 *                
 *  % java ThreeSumFast 4Kints.txt
 *  4039
 * 
 *  % java ThreeSumFast 8Kints.txt
 *  32074
 *
 *  % java ThreeSumFast 16Kints.txt
 *  255181
 *
 *  % java ThreeSumFast 32Kints.txt
 *  2052358
 *
 *************************************************************************/

import CH1.CH1_1.BinarySearch;
import CH1.CH1_4.Stopwatch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFast {


    public static void main(String[] args)  {
        int count = 1;int cnt = 0;
        System.out.println("Scale\tCount\t\tTime");
        System.out.println("---------------------------");
        while(count <= 32){
//            int [] data = In.readInts("src\\CH1\\CH1_4\\"+count+"Kints.txt");
//
            int [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8,4};            Stopwatch timer = new Stopwatch();
            cnt = count(data);

            if(count <= 2)
                System.out.printf("%-2dK\t\t%-3d\t\t\t%.3fs\n",count,cnt,timer.elapsedTime());
            else
                System.out.printf("%-2dK\t\t%-3d\t\t%.3fs\n",count,cnt,timer.elapsedTime());
            count*=2;
        }
    }
    // print distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static void printAll(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int k = BinarySearch.rank(a, -(a[i] + a[j]));
                if (k > j) StdOut.println(a[i] + " " + a[j] + " " + a[k]);
            }
        }
    }

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int k = BinarySearch.rank(a, -(a[i] + a[j]));
                if (k > j) cnt++;
            }
        }
        return cnt;
    }


} 
