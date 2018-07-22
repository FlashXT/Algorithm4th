
/********************************************************************************
 * 简介：排序算法一：插入排序Base;
 * Author：FlashXT;
 * Date:2018.7.22,Sunday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ******************************************************************************/

package CH2.InsertionSort;

import edu.princeton.cs.algs4.StdOut;

public class InsertionSort {
    public static void main(String [] args){
        int [] data = {34,27,25,24,18,100,7};

        int i,j,temp;
        for(i = 1; i < data.length;i++) {
            if (data[i] < data[i - 1]) {
                temp = data[i];
                for ( j = i - 1;j >=0&& temp < data[j] ; j--)
                    data[j + 1] = data[j];
                data[j + 1] = temp;
            }
            for(int k : data)
                StdOut.print(k+"\t");
            StdOut.println();
        }
        for(int k : data)
            StdOut.print(k+"\t");
//        int [] temp = new int[data.length+1];
//        for(int i = 1;i < temp.length;i++){
//            temp[i] = data[i-1];
//        }
//        for(int k = 0; k< temp.length;k++)
//            StdOut.print(temp[k]+"\t");
//        StdOut.println();
//        for(int i = 2; i < temp.length;i++){
//            if(temp[i] < temp[i-1]){
//                temp[0] = temp[i];
//                int j;
//                for(j = i-1; temp[0]< temp[j];j--)
//                    temp[j+1] = temp[j];
//                temp[j+1] = temp[0];
//            }
//
//            for(int k = 0; k< temp.length;k++)
//                StdOut.print(temp[k]+"\t");
//            StdOut.println();
//        }


    }

}
