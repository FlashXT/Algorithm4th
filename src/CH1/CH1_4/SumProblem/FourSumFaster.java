package CH1.CH1_4.SumProblem;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class FourSumFaster {

    public static void main(String [] args){
        StdOut.println("Scale\t\tCount\t\t\tTime\n---------------------------------------");
        for (int i = 1; i <= 32 ; i+=i ){
            int [] data = In.readInts("src\\CH1\\Data\\"+ i +"Kints.txt");
//            int [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8,4};
            Stopwatch st = new Stopwatch();

            StdOut.printf("%-2dk\t\t\t%-12d\t%-10.3fs\n",i,FourSum(data),st.elapsedTime());
        }

    }
    //双指针法
    public static int FourSum(int [] data){
        Arrays.sort(data);

        int count = 0;
        int curr0 = 0;
        int curr1 = 0;
        int top = 0;
        int tail = data.length - 1;
        while(curr0 < data.length-5){
            curr1 = curr0+1;
            while(curr1 < data.length-2){
                top = curr1+1;
                tail = data.length - 1;

                while(top < tail){

                    while(data[top] + data[tail] + data[curr1] > -data[curr0] && top < tail){   tail--;        }
                    while(data[top] + data[tail] + data[curr1]<   -data[curr0] && top < tail){   top++;         }
                    if(data[top] + data[tail]  + data[curr1] == -data[curr0] && top < tail )  {
                        //StdOut.println(""+data[curr]+","+data[top]+","+data[tail]);
                        top ++; count++;
                    }

                }
                curr1++;
            }
            curr0++;
        }

        return count;

    }
}
