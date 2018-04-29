/***************************************************************
 * 题目描述：1.4.16.在一个含有N个Double值的数组a[]，找出一堆最接近的值：
 * 两者之差的绝对值最小的两个数。要求程序的时间复杂度上界为O(N*lgN)
 * Author:FlashXT;
 * Date:2018.4.27,Friday;
 * CopyRight © 2018-2020,FlashXT & turboMan. All Right Reserved.
 *
 ***************************************************************/

package CH1.CH1_4.The_Nearest_Furthest_Pair;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class TheNearestPairBase {

    public static void main(String[] args){
        StdOut.println("Scale\tNum1\t\t\tNum2\t\t\tDistance\t\tTime");
        StdOut.println("--------------------------------------------------------------");
        for (int i = 1; i <= 32 ; i+=i ){
            double [] data = In.readDoubles("src\\CH1\\Data\\"+i+"Kints.txt");
//            double [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8};
            Stopwatch st = new Stopwatch();
            int[] result = NearestPair(data);
            StdOut.printf("%-3dk\t%-5.3f\t\t%-5.3f\t\t%-5.3f\t\t\t%-5.3fs\n",i,data[result[0]],data[result[1]],Math.abs(data[result[1]]-data[result[0]]),st.elapsedTime());
        }

    }

    //Brute Force算法，时间复杂度O(N^2)
    public static int[] NearestPair(double[] data){

        int [] result = new int[2];
        double  key = Math.abs(data[0] - data[1]);
        for(int i = 0; i < data.length ; i++){
           for(int j = i + 1; j < data.length ; j ++)
            {

              if(  Math.abs(data[i] - data[j]) < key ) {
                  key = Math.abs(data[i] - data[j]);
                  result[0] = i;result[1] = j;
              }

            }
        }
        return result;

    }
}
