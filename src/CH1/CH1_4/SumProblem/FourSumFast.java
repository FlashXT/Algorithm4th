package CH1.CH1_4.SumProblem;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class FourSumFast {

    public static void main(String [] args){
        StdOut.println("Scale\t\tCount\t\t\tTime\n---------------------------------------");
        for (int i = 1; i <= 32 ; i+=i ){
            int [] data = In.readInts("src\\CH1\\Data\\"+ i +"Kints.txt");
//            int [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8,4};
            Stopwatch st = new Stopwatch();

            StdOut.printf("%-2dk\t\t\t%-12d\t%-10.3fs\n",i,Count(data),st.elapsedTime());
        }

    }

    public static int Count(int [] data){
        Arrays.sort(data);
        int count = 0;
        for(int i = 0; i < data.length; i++)
            for(int j = i + 1; j < data.length; j++)
                for(int k = j + 1; k < data.length; k++){

                    int index = BinarySearch(data,k+1,data.length-1,-(data[i]+data[j]+data[k]));
                    if(index != -1) count++;
                      //下面的代码为处理数据有重复的版本
//                    int index = FindminIndex(data,k+1,-(data[i]+data[j]+data[k]));
//                    if (index != -1)StdOut.print(""+data[i]+","+data[j]+","+data[k]);
//                    count += HowMany(data,index,-(data[i]+data[j]+data[k]));
//                    if (index != -1)StdOut.println();

                }

        return count;
    }

    public static int FindminIndex(int [] data,int start,int key){
        int index = BinarySearch(data,start,data.length-1,key);
        if( index != -1){
            int temp = index;

            while(index != -1){
                temp = index;
                index = BinarySearch(data,start,index-1,key);
            }

            return temp;
        }
        return index;
    }

    public static int HowMany(int[] data,int start,int key){
        int count = 0;
        int index = start;

        while(index != -1){
            count ++;
//            StdOut.print(","+data[index]);
            index = BinarySearch(data,index+1,data.length-1,key);


        }
        return count;

    }

    //二分查找递归算法
    public static  int BinarySearch(int [] data,int start,int end,int key){
        if(start > end ) return -1;
        else if( key > data[(start+end)/2])
            return BinarySearch(data,(start+end)/2+1,end,key);
        else if(key < data[(start+end)/2])
            return BinarySearch(data,start,(start+end)/2-1,key);
        else
            return (start+end)/2;
    }


}
