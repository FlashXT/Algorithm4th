/********************************************************************
 * 关于查找：最小索引问题，How Many()问题，等
 * ①暴力算法，可以使用多重循环进行查找；但是效率随循环层数的增加而下降，
 *   超过3层循环就不应该再考虑暴力算法；
 * ②二分查找的递归算法及其变形，可以将一个N阶将为lgN阶，但是要先将原数据排序；
 * Author：FlashXT;
 * Date :2018.4.26,Thursday;
 * Copyright © 2018–2020 FlashXT and turboMan. All rights reserved.
 ********************************************************************/
package CH1.CH1_4.AboutFindElements;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MinIndex_Base_HowMany {
    public static void main(String [] args){
        int [] data = {1,2,3,4,56,23,56,78,90,23,58};
        Arrays.sort(data);
        for(int i : data)
            StdOut.printf("%-3d",i);
        StdOut.println();
        StdOut.println(FindminIndex(data,56));
        StdOut.println(HowMany(data,56));
    }

    //暴力算法（N阶）
    public static int FindminIndex(int [] data,int key){
        int i = 0;
        while(i < data.length)
        {
            if(data[i] == key) return i;
            i++;
        }
        return -1;
    }
   //暴力算法(N阶)
    public static int HowMany(int[] data,int key){
        int count = 0;
        int i = 0;
        while(data[i]< key) i++;
        while(data[i] == key) {i++;count++;}
        return count;

    }

}
