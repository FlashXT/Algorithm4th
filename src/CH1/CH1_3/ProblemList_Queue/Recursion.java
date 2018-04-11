package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

public class Recursion {
  public static void main (String [] args){
            int [] arr = {1,3,4,5};


           StdOut.println(max(arr,0,arr.length));

  }

    //P1.3.27递归方法


    public static  int max(int[] array,int start,int end){

        if (array.length == 1) return array[0];

        if(max(array,0,array.length/2) > max(array,array.length/2,array.length))
            return max(array,0,array.length/2);
        else return max(array,array.length/2,array.length);
    }
}
