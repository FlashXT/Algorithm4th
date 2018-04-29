package CH1.CH1_4.TheMinElement_of_local;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/***************************************************************************************
 * 题目：数组的局部最小元素。给定一个含有N个不同整数数组，找到一个局部最小元素：
 *      (1) a[i] < a[i-1];(2)a[i] < a[i+1]; 求出局部最小元素的索引i；
 *      要求程序在最坏情况下的年笔记次数为~2*lgN.
 *
 * 解题思路：设置一个长度为三的滑动窗口，从data[1]滑动到data[data.length-1],
 * 从符合条件的窗口中，寻找最小的元素；时间复杂度为O(N);但是比较次数最坏情况下为2N；
 *
 * 分析：
 *   ①本题要求找到一个局部最小元素，并未要求找到全局最小元素；表明找到任意一个局部最小元素就满足题意；
 *   ②数组中没有重复元素，保证了解一定存在；当数组中有重复元素时，解不一定存在；如数组元素全为1；
 *   ③边界情况，如data[0],data[length - 1]，它们只有一侧存在元素，那么只需要与单侧元素相比较即可；
 ****************************************************************************************/
public class TheMinElementOfLocalBase {

    public static void main(String [] args){
      int [] data = In.readInts("src\\CH1\\Data\\1Kints.txt");
//        int [] data = {3,4,5,7,8,9,7};
      int index = MinLocal(data);
      StdOut.println(index);
    }

    //时间复杂度为O(N)
    public static int MinLocal(int [] data){

        for(int i = 0; i < data.length; i++)
        {
            if(i == 0 ){
                if(data[i] < data[i+1]) return i;
            }
            else if(i == data.length -1 ){
                if(data[i] < data[i-1]) return i;
            }
            else if(data[i-1] > data[i] && data[i] < data[i+1]) return i;

        }
        return -1;
    }

    //时间复杂度为O(N),全局最小
    public static int MinLocal2(int [] data){
        int index = -1;
        int temp = Integer.MAX_VALUE;
        for(int i = 1; i < data.length-1; i++)
        {
            if(data[i-1] > data[i] && data[i] < data[i+1]){
                if(data[i] < temp){temp = data[i];index = i;}
            }
        }
        return index;
    }
}
