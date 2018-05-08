/***********************************************************************************
 * 题目：扔鸡蛋。假设你前面有一栋N层的大楼和许多鸡蛋，假设将鸡蛋从F层或者更高的地方扔下才会摔碎，
 *      否则不会。首先，设计一种策略来确定F的值，其中扔~lgN次鸡蛋后摔碎的鸡蛋数量为~lgN,然后
 *      想办法将成本降低到~2lgF.
 * 算法分析：第一问：二分查找即可；
 *         第二问：2^(k-1) < F < 2^(k),在[2^(k-1),2^(k)]范围内查找；
 *
 *
 *      >>>>>扔鸡蛋问题，既可以用数学推导法，也可以用动态规划法，DP方法后续补上。<<<<<
 *
 * Author:FlashXT;Date:2018.5.8,Tuesday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *************************************************************************************/

package CH1.CH1_4.CH1_4_24_25_ThrowEggs;

import edu.princeton.cs.algs4.StdOut;

public class throwEgg {
    public static void main(String [] args){
        int count = 0;
        BinarySearchlgN(0,19,count);
        BinarySearch2lgF();
    }
    public static int BinarySearchlgN(int start,int end,int count ){

        int mid = start + (end - start )/2;
        if(TEggs(mid) && !TEggs(mid - 1)) {count ++;StdOut.println(mid+","+count);return mid;}
        if(TEggs(mid)){
            count ++;
            return BinarySearchlgN( start,mid-1,count );
        }
        else return BinarySearchlgN( mid+1,end,count );
    }

    public static void BinarySearch2lgF(){


        int start =1;
        int end = 1;
        int count = 0;

        while(!TEggs(end)){
            start = end;
            end  = end *2;
        }
        count++;

        int mid = 0;
        while(!(TEggs(mid)&&!TEggs(mid-1))){

            mid = start + (end - start)/2;
            if(TEggs(mid)) {count ++;end = mid -1;}
            else start = mid +1;

        }
        count++;
        StdOut.println(mid +","+count);

    }

    public static boolean TEggs(int floor){
        int F = 14;
        return floor >= F;
    }
}
