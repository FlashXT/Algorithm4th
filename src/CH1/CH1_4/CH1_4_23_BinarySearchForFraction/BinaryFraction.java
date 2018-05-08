/**************************************************************************************************
 * 题目:分数的二分查找。设计一个算法，使用对数级别的比较次数找出有理数p/q，其中 0 < p < q < N,比较形式为给定的数是
 *     否小于x?提示：两个分母均小于N的有理数之差不小于1/N^2.
 * Author:FlashXT;Date:2018.5.7,Monday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *
 ***************************************************************************************************/


package CH1.CH1_4.CH1_4_23_BinarySearchForFraction;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinaryFraction {
    public static void main(String [] args){
        double [] data={1.2,2.5,3.6,5.7,6.9,10.2,11.3,12.7};
        Arrays.sort(data);
        StdOut.println(BinarySearch(data, 6.9));

    }
    public static int BinarySearch(double[] a, double key)
    {
        int lo = 0;
        int hi = a.length - 1;
        double threshold = 1.0 / (a.length * a.length);

        while (lo <= hi)
        {
            int mid = lo + (hi - lo) / 2;
            if (Math.abs(a[mid] - key) <= threshold)
            {
                return mid;
            }
            else if (a[mid] < key)
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
