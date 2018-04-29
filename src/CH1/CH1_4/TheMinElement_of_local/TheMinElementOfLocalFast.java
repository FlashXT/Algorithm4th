package CH1.CH1_4.TheMinElement_of_local;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TheMinElementOfLocalFast {

    public static void main(String [] args){
        int [] data = In.readInts("src\\CH1\\Data\\1Kints.txt");
//        int [] data = {3,4,5,7,8,5,7};
        int index = MinLocalRecursion(data,0,data.length-1);
        StdOut.println(index);
    }



    /***************************************************************************************
     * 题目：数组的局部最小元素。给定一个含有N个不同整数数组，找到一个局部最小元素：
     *      (1) a[i] < a[i-1];(2)a[i] < a[i+1]; 求出局部最小元素的索引i；
     *      要求程序在最坏情况下的年笔记次数为~2*lgN.
     *
     * 解题思路：(分治法)检查中间值a [N / 2]及其两个邻居a [N / 2 - 1]和[N / 2 + 1]。 如果[N / 2]是局
     *         部最小值，则停止; 否则继续在较小的邻居一侧寻找。
     *
     **************************************************************************************/
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


    //递归方法
    public static int MinLocalRecursion(int [] data,int start,int end){
         int mid = ( start + end )/2;
       if(data[mid-1] > data[mid] && data[mid] < data[mid +1])  return mid;
       if(data[mid-1] > data[mid+1]) return MinLocalRecursion(data,mid+1,end);
       else return MinLocalRecursion(data,start,mid-1);
    }

}
