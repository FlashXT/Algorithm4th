package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

public class Recursion27_3 {

    public static void main(String[] rags){
        int [] aim ={1,2,3,43,5,6,56,45,67,1,3,4,10};
        int max = aim[0];
        max =  getMax(aim,max,0);
        StdOut.println("Max = "+ max);

    }

    //递归方法
    public static int getMax(int[] aim,int max,int point){
        if(point==aim.length)  return max;

        if(max < aim[point])   return getMax(aim,aim[point],point+1);
        else                   return getMax(aim,max,point+1);
    }
}
