package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

public class Recursion27 {
  public static void main (String [] args){
            int [] arr = {1,3,4,5,21321312,12,4,45,23231,10};
            StdOut.println(max(arr,0,arr.length-1));

  }

    //P1.3.27递归方法


    public static  int max(int[] array,int start,int end){

        if (start == end) return array[start];

        if(max(array,start,start+(end - start)/2) < max(array,start+(end - start)/2+1,end))
             return max(array,start+(end - start)/2+1,end);

        else return max(array,start,start+(end - start)/2);
    }
}
