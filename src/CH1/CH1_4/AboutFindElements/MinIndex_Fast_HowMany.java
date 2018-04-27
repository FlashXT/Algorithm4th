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

import CH1.CH1_1.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class MinIndex_Fast_HowMany {
    public static void main(String [] args){
        int [] data = {1,2,3,4,56,23,56,78,90,23,58};//In.readInts("src\\CH1\\CH1_4\\1Kints.txt");
        Arrays.sort(data);
        for(int i : data)
            StdOut.printf("%-3d",i);
        StdOut.println();
        StdOut.println(FindminIndex(data,56));
        StdOut.println(HowMany(data,56));
    }

    //查找与被查找元素匹配的索引最小的元素(lgN级别)
    //查找思路：利用二分查找的递归算法，先找到该元素(假设该元素存在)，假设该元素在数组中有若干个，
    //第一次找到的是中间那个，那么再次利用二分查找在[0,index-1]范围内递归查找；直到在该半
    //区查找不到为止，然后返回上次的index值就是最小的index值；
    public static int FindminIndex(int [] data,int key){
      int index = BinarySearch(data,0,data.length-1,key);
      if( index != -1){
          int temp = index;

          while(index != -1){
              temp = index;
              index = BinarySearch(data,0,index-1,key);
          }

          return temp;
      }
      return index;
    }
    //How Many()问题 (lgN阶)
    //查找思路：利用二分查找的递归算法，先找到该元素(假设该元素存在)，假设该元素在数组中有若干个，
    //然后再次利用二分查找分别在[0,index-1]和[index+1，data.length - 1]范围内递归查找并计数；
    //直到在这两个半区查找不到为止，然后返回计数值，就是该元素在数组中个数；
    public static int HowMany(int[] data,int key){
        int count = 0;
        int index0 =  BinarySearch(data,0,data.length-1,key);
        int index1 =  BinarySearch(data,0,data.length-1,key);
        if(index0 == -1) return 0;
        while(index0 != -1){
            count ++;
            index0 = BinarySearch(data,0,index0-1,key);

        }
        while(index1 != -1){
            count ++;
            index1 = BinarySearch(data,index1+1,data.length-1,key);

        }
        return --count;

    }

    //二分查找递归算法
    public static  int BinarySearch(int [] data,int start,int end,int key){
        if(start > end ) return -1;
        else if( key > data[(start+end)/2])
            return BinarySearch(data,(start+end)/2+1,end,key);
        else if(key < data[(start+end)/2])
            return BinarySearch(data,start,(start+end)/2-1,key);
        else
            return (start+end)/2;
    }
}
