/************************************************************************************
 * Algorithm4th,CH1.4.20,双调查找；
 * Author:FlashXT
 * Date:2018.5.2,Wednesday；
 *
 * 算法思路：Use a version of binary search to find the maximum (in ~ 1 lg N compares);
 * then use binary search to search in each piece (in ~ 1 lg N compares per piece).
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *************************************************************************************/
package CH1.CH1_4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class BitonicSearch {
    public static void main(String [] args){
        int [] arr = {1,2,3,4,7,8,12,15,20,19,17,14,12,10,8,7};
        int maxindex = BinFindMax(arr,0,arr.length-1);
        StdOut.println("Input key : ");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        int index0 = BinarySearchUp(arr,0,maxindex,key);
        int index1 = BinarySearchDown(arr,maxindex,arr.length-1,key);
        if(index0 != -1)
         StdOut.println(index0);
        if(index1 != -1)
         StdOut.println(index1);
     }
     public static int BinFindMax(int [] array,int start,int end){
        if(start == end) return start;
        int mid = (start + end)/2;

        if(array[mid] > array [mid -1]) return  BinFindMax(array,mid,end);
        else  return  BinFindMax(array,start,mid-1);
     }
    public static int BinarySearchUp(int [] array,int start,int end,int key){
        if(start > end) return -1;
        int mid = (start+end)/2;
        if(array[mid] == key) return mid;
        else if(array[mid] > key) return BinarySearchUp(array, start,mid-1,key);
        else return BinarySearchUp(array,mid+1,end, key);
    }
    public static int BinarySearchDown(int [] array,int start,int end,int key){
        if(start > end) return -1;
        int mid = (start+end)/2;
        if(array[mid] == key) return mid;
        else if(array[mid] < key) return BinarySearchUp(array, start,mid-1,key);
        else return BinarySearchUp(array,mid+1,end, key);
    }

}
