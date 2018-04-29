package CH1.CH1_4.The_Nearest_Furthest_Pair;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class TheFurthestPairFaster {

    public static void main(String[] args){
        StdOut.println("Scale\t\tNum1\t\t\tNum2\t\t\tDistance\t\tTime");
        StdOut.println("------------------------------------------------------------------" );
        for (int i = 1; i <= 32 ; i+=i ){
            double [] data = In.readDoubles("src\\CH1\\Data\\"+i+"Kints.txt");
//            double [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8};
            Stopwatch st = new Stopwatch();
            double[] result = FurthestPair(data);
            StdOut.printf("%-3dk\t%-5.3f\t\t%-5.3f\t\t%-5.3f\t\t\t%-5.3fs\n",i,result[0],result[1],result[1]-result[0],st.elapsedTime());
        }

    }



    //算法思路：直接找出数据中额最大最小值即可；时间复杂度为O(N)

    public static double[] FurthestPair(double[] data){
        double[] result = new double[2];
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        for(int i = 0; i < data.length ; i++){
            if(data[i] > max) max = data[i];
            if(data[i] < min) min = data[i];
        }
        result[0] = min;result[1] = max;
     return  result;
    }
}
