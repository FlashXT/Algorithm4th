/***************************************************************
 * CH1.4.12,打印出两个数组中的公共元素，程序在最坏情况下的运行时间为O(N);
 * Author:FlashXT;
 * Date:2018.4.24,Tuesday;
 *
 ****************************************************************/

package CH1.CH1_4.CH1_4_12;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Solution_1 {
    public static void main(String [] args){

        int N=20;
        int[] a = new int[N];
        int[] b = new int[N];
        for(int i=0;i<N;i++){
            a[i]=(int)(StdRandom.random()*50);
            b[i]=(int)(StdRandom.random()*50);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int pa=0,pb=0,p=0;
        int[] ans = new int[N];
        while(pa<a.length && pb<b.length){
            while(pa<a.length && pb<b.length && a[pa]==b[pb]){
                ans[p++]=a[pa];
                pa++;
                pb++;
            }
            while(pa<a.length && pb<b.length && a[pa]<b[pb]){
                pa++;
            }
            while(pa<a.length && pb<b.length && a[pa]>b[pb]){

                pb++;
            }
        }
        for(int i:a)
            StdOut.print(i+" ");
        StdOut.println();
        for(int i:b)
            StdOut.print(i+" ");
        StdOut.println();
        for(int i:ans)

            StdOut.print(i+" ");
        StdOut.println();
    }




}
