package CH1.CH1_4.The_Nearest_Furthest_Pair;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class TheFurthestPairFast {


    public static void main(String[] args){
        StdOut.println("Scale\tNum1\t\t\tNum2\t\t\tDistance\t\t\tTime");
        StdOut.println("------------------------------------------------------------------" );
        for (int i = 1; i <= 32 ; i+=i ){
            double [] data = In.readDoubles("src\\CH1\\CH1_4\\"+i+"Kints.txt");
//            double [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8};
            Stopwatch st = new Stopwatch();
            int[] result = FurthestPair(data);
            StdOut.printf("%-3dk\t%-5.3f\t\t%-5.3f\t\t%-5.3f\t\t\t%-5.3fs\n",i,data[result[0]],data[result[1]],data[result[1]]-data[result[0]],st.elapsedTime());
        }

    }


    /*****************************************************************
     * 算法思路：
     * ①先对数据进行排序；
     * ②排完序的数据，data[0]与data[data.length - 1]的距离肯定最远；
     *
     *****************************************************************/

    //排序(归并排序)的时间复杂度为O(N*lgN)
    public static int[] FurthestPair(double[] data){
        Arrays.sort(data);

        int [] result = new int[2];
        result[0] = 0;
        result[1] = data.length-1;
        return result;

    }
}
