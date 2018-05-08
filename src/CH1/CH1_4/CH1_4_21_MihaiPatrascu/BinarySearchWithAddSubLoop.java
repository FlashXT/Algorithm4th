/**************************************************************************************************
 * 题目:仅用加减法实现二分查找。给定含有N个不同int值，按照升序排列的数组，判断它是否含有给定的整数。使用斐波那
 *     契数列代替2的幂进行查找，要求只能使用加法和减法以及常数的额外空间，程序的运行时间在最坏情况下应该该和
 *     logN成正比。
 *
 * 算法分析：如何利用引入的斐波那契数列（0，1，1，2，3，5，8，13，21，。。。）？每次查找不能进行折半，那么mid
 *         值就无法确定，利用斐波那契数列来代替mid值，循环版的方法开始先求出合适的斐波那契数列的数值，然后每一次循环
 *         减小斐波那契数列的值(相当于减小high,但是这中方法在查找过程中并没有用到high)，并且在data[index] < key时，
 *         增大low的值，每一次循环，查找的区间就会缩小；
 * Author:FlashXT;Date:2018.5.7,Monday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 ***************************************************************************************************/
package CH1.CH1_4.CH1_4_21_MihaiPatrascu;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearchWithAddSubLoop {
    public static void main(String [] args){
        int [] data = {1,2,4,7,9,10,12,13,14,17,18,20,21,34,45,56,76};
        Arrays.sort(data);

        StdOut.println(BinarySearchAS(data,56));
    }

 public static int BinarySearchAS(int [] data,int key){
    int Fk = 1;
    int Fk_1 = 1;
    int Fk_2 = 0;

     //求出合适的斐波那契数列的数值
    while(Fk < data.length){
        Fk = Fk + Fk_1;
        Fk_1 = Fk_1 + Fk_2;
        Fk_2 = Fk - Fk_1;
    }
    int low = 0;//可以设置任意值

    while(Fk_2 >= 0){
        int index = low+Fk_2 < data.length-1 ? low+Fk_2 : data.length-1;
        //增大low
        if(data[index] < key) low = low + Fk_2;
        if(data[index] == key) return index;

        //减小斐波那契数列的值，相当与减小high，其实随着减小的时low的增量
        Fk=Fk_1;
        Fk_1=Fk_2;
        Fk_2 = Fk-Fk_1;
    }
    return -1;
}

    public static int Fibnacci(int N){
        if( N == 1 || N== 0) return 1;
        return Fibnacci(N-1)+Fibnacci(N-2);

    }
}
