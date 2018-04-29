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

import CH1.Tools.Stopwatch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class ThreeSumFaster {


    public static void main(String[] args)  {
        int count = 1;int cnt = 0;
        System.out.println("Scale\tCount\t\tTime");
        System.out.println("---------------------------");
        while(count <= 32){
            int [] data = In.readInts("src\\CH1\\Data\\"+count+"Kints.txt");
//            int [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8,4};
            Stopwatch timer = new Stopwatch();
            cnt = ThreeSum(data);//threeSumFaster(data);//
            System.out.printf("%-2dK\t\t%-7d\t\t%.3fs\n",count,cnt,timer.elapsedTime());
            count*=2;
        }
    }

    //双指针法
    public static int ThreeSum(int [] data){
        Arrays.sort(data);

        int count = 0;
        int curr = 0;
        int top = 0;
        int tail = data.length - 1;

        while(curr < data.length-2){
            top = curr+1;
            tail = data.length - 1;

            while(top < tail){

                while(data[top] + data[tail]  > -data[curr] && top < tail){   tail--;        }
                while(data[top] + data[tail]  < -data[curr] && top < tail){   top++;         }
                if(data[top] + data[tail] == -data[curr] && top < tail )  {
                    //StdOut.println(""+data[curr]+","+data[top]+","+data[tail]);
                    top ++; count++;
                }

            }
            curr++;
        }
        return count;

    }


} 
