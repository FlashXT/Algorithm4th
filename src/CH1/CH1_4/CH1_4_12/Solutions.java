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

public class Solutions {

    public static  int[] a,b,ans;

    public static void main(String [] args){
        ans = new int[a.length<b.length?a.length:b.length];

        CreateArray(20,50);
        Solution0(ans);
        Print();

    }
    public static void CreateArray(int N,int range) {
        a = new int[N];
        b = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = (int) (StdRandom.random() * range);
            b[i] = (int) (StdRandom.random() * range);
        }
    }
    public static void Print(){
        StdOut.print("a:");
        for(int i:a)
            StdOut.print(i+" ");
        StdOut.print("\nb:");
        for(int i:b)
            StdOut.print(i+" ");
        StdOut.println("\nResults:");
        for(int i:ans)
            StdOut.print(i+" ");
        StdOut.println();
    }
    //暴力算法，双重循环，N^2阶
    public static void Solution0(int[] ans) {

        int k = 0;
        for(int i = 0; i<a.length;i++)
            for(int j = 0; j <b.length;j++)
                if(a[i] == b[j]) ans[k++] = a[i];
    }
    //N阶
    public static void Solution1(int[] ans){

        Arrays.sort(a);
        Arrays.sort(b);

        int pa=0,pb=0,p=0;

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
    }
}
