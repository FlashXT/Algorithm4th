package CH1.CH1_4.SumProblem;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class FourSumBase {

    public static void main(String [] args){
        StdOut.println("Scale\tCount\tTime\n----------------------");
        for (int i = 1; i <= 32 ; i+=i ){
            int [] data = In.readInts("src\\CH1\\CH1_4\\"+i+"Kints.txt");
//            int [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8,4};
            Stopwatch st = new Stopwatch();

            StdOut.printf("%-2dk\t\t%-5d\t%-6.3fs\n",i,Count(data),st.elapsedTime());
        }

    }

    public static int Count(int [] data){
        int count = 0;
        Arrays.sort(data);
        for(int i = 0; i < data.length; i++)
            for(int j = i+1; j < data.length; j++)
                for(int k = j+1; k < data.length; k++)
                    for(int l = k+1; l < data.length; l++){
                        if(data[i]+data[j]+data[k]+data[l] == 0){
                            count++;
                           // StdOut.println(""+data[i]+","+data[j]+","+data[k]+","+data[l]);
                        }
                    }

        return count;
    }


}
