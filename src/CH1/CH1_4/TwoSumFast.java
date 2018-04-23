package CH1.CH1_4;

import CH1.CH1_1.BinarySearch;
import CH1.CH1_1.recursionBinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class TwoSumFast {
    public static void main(String [] args){

        int count = 1;int cnt = 0;
        System.out.println("Scale\tCount\tTime");
        System.out.println("----------------------");
        while(count <= 32){
            int [] data = In.readInts("src\\CH1\\CH1_4\\"+count+"Kints.txt");

            Stopwatch timer = new Stopwatch();
            cnt = count(data);
            System.out.printf("%-2dK\t\t%3d\t\t%.3fs\n",count,cnt,timer.elapsedTime());
            count*=2;
        }

    }
    public static int count(int [] data){
        int cnt = 0;
        Arrays.sort(data);
        for(int i = 0; i < data.length ; i++){
            int k = BinarySearch(data,-data[i] );
//            int k = RecursonBinarySearch(data,0,data.length-1,-data[i] );
            if( k > i) cnt++;
        }
        return cnt;
    }
    public static int BinarySearch(int []a,int key){

        int low = 0;
        int high = a.length - 1;

        while(low <= high){
            int mid = ( low + high ) / 2;
            if( key < a[mid] )           high = mid - 1;
            else if (key > a[mid])        low = mid + 1;
            else                          return mid;

        }
        return -1;
    }

    public static int RecursonBinarySearch(int []a,int low,int high,int key){

        if(low > high)           return -1;
        int mid = (low+high)/2;
        if       (key == a[mid]) return mid;
        else if  (key < a[mid])  return RecursonBinarySearch(a,low,mid-1,key);
        else                     return RecursonBinarySearch(a,mid+1,high,key);
    }
}
