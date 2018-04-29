package CH1.CH1_4.SumProblem;

import CH1.CH1_1.BinarySearch;
import CH1.Tools.Stopwatch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class ThreeSumFast {

    public static void main(String[] args)  {
        int count = 1;int cnt = 0;
        System.out.println("Scale\tCount\t\tTime");
        System.out.println("---------------------------");
        while(count <= 32){
            int [] data = In.readInts("src\\CH1\\Data\\"+count+"Kints.txt");
//            int [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8};
            Stopwatch timer = new Stopwatch();
            cnt = count(data);
            System.out.printf("%-2dK\t\t%-7d\t\t%.3fs\n",count,cnt,timer.elapsedTime());

            count*=2;
        }
    }

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
