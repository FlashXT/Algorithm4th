
/********************************************************************************
 * 简介：排序算法一：2-路插入排序;直接插入排序包含两个基本过程，移动记录与比较，因此改进的话，就
 *      要从移动记录次数和比较次数进行改进；折半插入排序从减少比较次数入手进行改进；不稳定的
 *      排序算法；2-路插入排序在折半插入排序的基础上再改进，通过减少在排序过程中移动记录的次数提高
 *      排序的效率，但是需要n个记录的辅助空间。
 * Author：FlashXT;
 * Date:2018.7.22,Sunday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ******************************************************************************/

package CH2.InsertionSort;

import edu.princeton.cs.algs4.StdOut;

public class TwoWaysInsertionSort {
    public static void main(String [] args) {
        int[] data = {34, 27, 25, 24, 24, 18, 100, 7, 9 ,123};
        int [] temp = new int [data.length];
        int first = data.length/2,tail = data.length/2;
        temp[first] = data[0];
        for (int i = 1; i < data.length; i++) {

            if (data[i] <= temp[first]) {

                temp[(first-1+temp.length)%temp.length] = data[i];
                first =(first-1+temp.length)%temp.length;

            }
             else if(data[i] >= temp[tail]) {
                temp[(tail+1)%temp.length] = data[i];
                tail = (tail+1)%temp.length;
            }
            else{
                int low = first;
                int high = tail;
                int mid = (low + high)%temp.length /2;
                while(temp[mid] > data[i]){
                    if(temp[mid] < data[i])
                        low = mid+1;
                    else
                        high = mid-1;

                    mid = (low + high)/2;

                }
                while(  )
                temp[mid] = data[i] ;
                first = (first-1+temp.length)%temp.length;
            }


            for (int k : temp)
                StdOut.print(k + "\t");
            StdOut.println();
        }
        for (int k : temp)
            StdOut.print(k + "\t");
        StdOut.println();
    }
}
