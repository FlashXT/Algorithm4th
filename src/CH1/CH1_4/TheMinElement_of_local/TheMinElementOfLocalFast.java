package CH1.CH1_4.TheMinElement_of_local;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TheMinElementOfLocalFast {

    public static void main(String [] args){
        int [] data = In.readInts("src\\CH1\\CH1_4\\1Kints.txt");
//        int [] data = {3,4,5,7,8,5,7};
        int index = MinLocal(data);
        StdOut.println(index);
    }
    //时间复杂度为O(lgN)，比较次数为O(lgN)
    public static int MinLocal(int [] data){

        int low = 0;
        int high = data.length-1;
        int mid = (low + high) / 2;
        while(low < high){
            if(data[mid-1] > data[mid] && data[mid] < data[mid +1]) return mid;
            else if(data[mid-1] < data [mid+1] ) high = mid - 1;
            else low = mid +1;
            mid = (low + high) / 2;
        }
        return low;
    }

}
