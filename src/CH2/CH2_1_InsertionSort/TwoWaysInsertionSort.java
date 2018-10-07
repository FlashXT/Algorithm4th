
/*********************************************************************************
 * 简介：排序算法一：2-路插入排序;直接插入排序包含两个基本过程，移动记录与比较，因此改进的话，就
 *      要从移动记录次数和比较次数进行改进；折半插入排序从减少比较次数入手进行改进；不稳定的排序
 *      算法；2-路插入排序在折半插入排序的基础上再改进，通过减少在排序过程中移动记录的次数提高排
 *      序的效率，但是需要n个记录的辅助空间，类似于循环队列，难点在于temp中元素物理位置与逻辑位置
 *      的转化；
 * Author：FlashXT;
 * Date:2018.7.22,Sunday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ******************************************************************************/

package CH2.CH2_1_InsertionSort;

import edu.princeton.cs.algs4.StdOut;

public class TwoWaysInsertionSort {
    public static void main(String [] args) {
        int [] data = {34, 27, 25, 24, 24, 18, 100,7,7,7,8,7,123,9,112,101,22,104,104,99};
        int [] temp = new int [data.length];
        //开始时，把待排序序列中的第一个值放到temp的中间位置；
        int first = data.length/2,tail = data.length/2;
        temp[first] = data[0];
        //从第一个数据开始排序
        for (int i = 1; i < data.length; i++) {

            //如果data[i]> temp[first]，则说明data[i]是当前有序序列中最小的，直接放到第一个位置；
            if (data[i] <= temp[first]) {
                first =(first-1+temp.length)%temp.length;
                temp[first] = data[i];
            }
            //如果data[i]> temp[tail]，则说明data[i]是当前有序序列中最大的，直接放到最后一个位置；
            else if(data[i] >= temp[tail]) {
                tail = (tail+1)%temp.length;
                temp[tail] = data[i];
            }
            //data[i]处于当前有序序列的中间，该种情况稍显复杂；
            else{
                //利用二分查找确定data[i]，在有序序列中的大致位置；因为有序序列中大概率不存在data[i],
                // 所以二分查找只能确定data[i]的大致位置；
                int low = first;
                int high;
                //结合first和tail在temp中的实际位置与逻辑位置进行转化；
                if(first > tail)
                    high = tail+temp.length;
                else
                    high = tail;
                int mid = (low + high)/2;
                while (high > low ) {
                    if (temp[mid%temp.length] > data[i]) high = mid -1 ;
                    else low = mid+1;
                    mid = (low + high)/2;
                }
                //因为二分查找中判断的是temp[mid] > data[i],但是最后循环的跳出条件是high <= low,所以temp[mid]
                //的位置的值可能大于或小于或等于data[i],此时需要队mid的值进行微调；temp[mid]的值大于或等于data[i]
                //都不会引起问题，但是temp[mid] < data[i],就会引起问题；因此针对这种病情况进行调整；
                while(temp[mid%temp.length] < data[i]) mid++;

                int j;
                //确定了data[i]要插入的位置，那么就需要从tail开始，移动[mid,tail]的元素，为data[i]在有序序列中空出位置；
                for (j = tail; j >= mid%temp.length; j--) {
                    temp[(j+1)%temp.length] = temp[j];
                }
                //将data[i]放入temp[mid]中，完成排序
                temp[mid%temp.length] = data[i];
                //将tail的值加1
                tail = (tail+1)%temp.length;

            }
            //用于输入每次排序的结果,temp中元素的物理位置
            for (int k : temp)
                StdOut.print(k + "\t");
            StdOut.println();
        }
        //根据first与tail的相对位置关系，输入temp中元素的逻辑位置
        if(first > tail)
            for (int i = first; i <= tail+temp.length;i++)
                StdOut.print(temp[i%temp.length] + "\t");
        else
            for (int i = first; i <= tail;i++)
                StdOut.print(temp[i] + "\t");

    }
}
