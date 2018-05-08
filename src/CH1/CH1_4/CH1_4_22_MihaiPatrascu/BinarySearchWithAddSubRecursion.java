/***************************************************************************************************
 * 题目:仅用加减法实现二分查找。给定含有N个不同int值，按照升序排列的数组，判断它是否含有给定的整数。使用斐波那
 *     契数列代替2的幂进行查找，要求只能使用加法和减法以及常数的额外空间，程序的运行时间在最坏情况下应该该和
 *     logN成正比。
 *
 * 算法分析：如何利用引入的斐波那契数列（0，1，1，2，3，5，8，13，21，。。。）？每次查找不能进行折半，那么mid
 *         值就无法确定，利用斐波那契数列来代替mid值，根据data[i+Fk_2]与key的大小里确定继续在哪个区查找；递归
 *         算法的开始阶段，data[index] < key;不断递归求出斐波那契数列的合适值，使得data[index] > key;
 *
 * 简单的思考：为什么斐波那契数列可以精确的找到一个key的下标？答：当data[index] >key时，斐波那契数列值减小，相
 *           当于二分法中的high减小；当data[index] < key时，low 增大，相当于二分法中的low增大，当index在
 *           key的左右一个小区间时，斐波那契数列的值足够小如（0，1），low的值足够大，,此时就可以差查找到key的下标；
 * Author:FlashXT;Date:2018.5.7,Monday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 ***************************************************************************************************/

package CH1.CH1_4.CH1_4_22_MihaiPatrascu;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearchWithAddSubRecursion {
    public static void main(String [] args){
        int [] data = {1,2,4,7,9,10,12,13,14,17,18,20,21,34,45,56,76};
        Arrays.sort(data);

        StdOut.println(BinarySearch(data,10));

    }

    public static int BinarySearch(int []data,int key){
        int [] F=new int[2];
        F[0] = 0; F[1] = 1;

        return BinarySearchAS(data,F,0,key);
    }
    public static int BinarySearchAS(int [] data,int [] Fs,int low,int key){
        //low从0开始递增，若low 大于数组的长度则说明数组中key不存在；
        if(low >data.length-1 )return -1;
        //防止下标越界；
        int index = low + Fs[1]-Fs[0] > data.length -1 ? data.length -1:low + Fs[1]-Fs[0];

        //如果data[index] == key，则返回下标；
        if(data[index] == key) return index;
        //如果data[index] > key ,应该向左半区查找，此时减小斐波那契数列的值，相当于减小high
        if(data[index] > key)  {
            int temp = Fs[1];Fs[1] = Fs[0];Fs[0] = temp - Fs[1];
            return BinarySearchAS(data,Fs,low,key);
        }
        //如果data[index] < key ,应该向右半区查找，此时增大low的值，并增大斐波那契数列的值
        else {
            low = low + Fs[0];
            int temp = Fs[1];Fs[1] = Fs[1]+Fs[0];Fs[0] = temp;
            return BinarySearchAS(data,Fs,low,key);
        }

    }
    //递归生成斐波那契数列
    public static int Fibnacci(int N){
        if( N == 1 || N== 0) return 1;
        return Fibnacci(N-1)+Fibnacci(N-2);

    }
}
