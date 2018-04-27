package CH1.CH1_4.SumProblem;

import CH1.CH1_4.Stopwatch;
import edu.princeton.cs.algs4.In;

public class TwoSumBase {
    public static void main(String [] args){
        int count = 1;int cnt = 0;
        System.out.println("Scale\tCount\tTime");
        System.out.println("----------------------");
        while(count <= 32){
            int [] data = In.readInts("src\\CH1\\CH1_4\\"+count+"Kints.txt");
//            int [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8,4};
            Stopwatch timer = new Stopwatch();
            cnt = count(data);
            System.out.printf("%-2dK\t\t%3d\t\t%.3fs\n",count,cnt,timer.elapsedTime());
            count*=2;
        }

    }
    public static int count(int [] data){
        int cnt = 0;
        for(int i = 0; i < data.length ; i++)
            for(int j = i+1; j < data.length ; j++ )
                if(data[i] + data[j] == 0) cnt++;
        return cnt;
    }
}
