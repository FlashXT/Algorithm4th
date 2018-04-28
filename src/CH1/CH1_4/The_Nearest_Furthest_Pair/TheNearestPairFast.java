

package CH1.CH1_4.The_Nearest_Furthest_Pair;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class TheNearestPairFast {
    public static void main(String[] args){
        StdOut.println("Num1\t\t\tNum2\t\t\tDistance\t\tTime");
        StdOut.println("------------------------------------------------------");
        for (int i = 1; i <= 32 ; i+=i ){
            double [] data = In.readDoubles("src\\CH1\\CH1_4\\"+i+"Kints.txt");
//            double [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8};
            Stopwatch st = new Stopwatch();
            int[] result = NearestPair(data);
            StdOut.printf("%-5.3f\t\t%-5.3f\t\t%-5.3f\t\t\t%-5.3fs\n",data[result[0]],data[result[1]],data[result[1]]-data[result[0]],st.elapsedTime());
        }

    }


    /*****************************************************************
     * 算法思路：
     * ①先对数据进行排序；
     * ②排完序的数据，每个数据与自己左右相邻的数据间的距离必然比距离其他元素
     *   的距离近，所以距离最近的一对元素必然是相邻的；
     * ③在一次遍历中，计算相邻元素的距离，并取最小值便可以求出最近距离的一对；
     *
     * 注意：key的初值不能设为0；当数据中没有距离为0的一对，则程序出错；Key的
     *     初值可以设为   key = data[1] - data[0]
     *             或者  key = Double.POSITIVE_INFINITY
     *
     *****************************************************************/

    //排序(归并排序)的时间复杂度为O(N*lgN)，则该算法的时间复杂度为O(N*lgN + N)
    public static int[] NearestPair(double[] data){
        Arrays.sort(data);

        int [] result = new int[2];
        double key = data[1] - data[0];

        for(int i = 2; i < data.length ; i++){

            if(  data[i] - data[i-1] < key  ){
                key = data[i] - data[i-1];
                result[1] = i;
            }
        }
        result[0] = result[1] - 1;
        return result;

    }
}
