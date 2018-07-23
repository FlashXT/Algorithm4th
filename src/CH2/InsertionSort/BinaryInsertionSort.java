
/********************************************************************************
 * 简介：排序算法一：折半插入排序;直接插入排序包含两个基本过程，移动记录与比较，因此改进的话，就
 *      要从移动记录次数和比较次数进行改进；折半插入排序从减少比较次数入手，进行改进；不稳定的
 *      排序算法
 * Author：FlashXT;
 * Date:2018.7.22,Sunday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ******************************************************************************/

package CH2.InsertionSort;

import edu.princeton.cs.algs4.StdOut;

public class BinaryInsertionSort {
    public static void main(String [] args) {
        int[] data = {34, 27, 25, 24, 24, 18, 100, 7, 9 , 7,123,6};

        int i, j, temp;
        for (i = 1; i < data.length; i++) {
            if (data[i] < data[i - 1]) {
                temp = data[i];
                int low = 0;
                int high = i - 1;

                int mid = (low + high)/2;
                while (high > low) {
                    if (temp < data[mid]) high = mid-1;
                    else low = mid+1;
                    mid = (low + high)/2;
                }
                for (j = i; j > mid; j--) {
                    data[j] = data[j - 1];
                }
                data[j] = temp;

            }
            for (int k : data)
                StdOut.print(k + "\t");
            StdOut.println();
        }
        for (int k : data)
            StdOut.print(k + "\t");
        StdOut.println();
    }
}
