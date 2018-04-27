package CH1.CH1_4.SumProblem;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;
import java.util.Hashtable;

/******************************************************
 * TwoSum,以排序好的数组，要求时间复杂度为线性级别O(n);
 * 目前有两种思路：
 * ①HashTable/HashMap:建立HashTable时间复杂度在O(1)~O(n);然后在HashTable/HashMap中查找，
 *   时间复杂度在O(1)~O(n)之间；
 * ②利用数组有序的特点，使用双指针法，一个从数组头部遍历，另一个从数组尾部遍历；查找时间为O(n);
 * Author:FlashXT;
 * Date:2018.4.27,Friday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 */

public class TwoSumFaster {
    public static void main(String [] args){
        StdOut.println("Scale\tCount\tTime\n----------------------");
        for (int i = 1; i <=32 ; i+=i ){
            int [] data = In.readInts("src\\CH1\\CH1_4\\"+i+"Kints.txt");
//            int [] data = {1,-1,2,-2,3,4,5,6,-3,-4,-7,8,4};
            Stopwatch st = new Stopwatch();

            StdOut.printf("%-2dk\t\t%-5d\t%-6.3fs\n",i,TwoSum(data),st.elapsedTime());
        }



    }

    //双指针法
//    public static int TwoSum(int [] data){
//        Arrays.sort(data);
//        int top = 0;
//        int tail = data.length - 1;
//        int count = 0;
//        while(top < tail){
//
//            while(data[top] + data[tail] > 0) {   tail--;   }
//            while(data[top] + data[tail] < 0 ){   top++;    }
//            if(data[top] + data[tail] == 0) {top++;count++;}
//            //if(data[top] + data[tail] == 0) {tail--;count++;}
//        }
//        return count;
//
//    }
    //hashTable法
    public static int TwoSum(int[] data){
        //构造HashTable
        Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
        for(int i = 0; i < data.length;i++)
            table.put(data[i],i);

        int top = 0,count = 0;
        //int range = table.
        while(top < data.length){
            if(table.containsKey(-data[top])) count++;
            top++;
        }
        return count/2;
    }
}
