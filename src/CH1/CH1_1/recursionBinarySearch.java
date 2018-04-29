/*Algorithm4th,CH1_P1.1.22,BinarySearch修改版，
* Author:FlashXT
* Date:2018.3.28,wednesday
* */
package CH1.CH1_1;

import java.util.Arrays;
public class recursionBinarySearch {
    public static void main(String [] args){
            int []a={1,2,34,54,21,3,22,41,6,45,67,23,57,78,37};
            Arrays.sort(a);
            int count=0;
            System.out.println("Key:"+BinarySearch(a,0,a.length-1,45,count));

    }

    public static int BinarySearch(int []a,int low,int high,int key,int count){
        System.out.printf("%d>>>\t",++count);
        System.out.println(low+"   "+high);
        if(low > high)           return -1;
        int mid = (low+high)/2;
        if       (key == a[mid]) return key;
        else if  (key < a[mid])  return BinarySearch(a,low,mid-1,key,count);
        else                     return BinarySearch(a,mid+1,high,key,count);
    }
}
