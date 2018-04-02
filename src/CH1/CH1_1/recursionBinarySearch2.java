/*Algorithm4th,CH1_P1.1.23,BinarySearch修改版，
 * */

package CH1.CH1_1;
import java.util.*;
public class recursionBinarySearch2 {
    public static void main(String [] args){
        int []a={1,2,34,54,21,3,22,41,6,45,67,23,57,78,37};
        Arrays.sort(a);
        int []key={1,3,45,56,34,78,99,12,23,67};
        BinarySearch(a,0,a.length-1,key,'+');
        System.out.println();
        BinarySearch(a,0,a.length-1,key,'-');
    }

    public static void BinarySearch(int []a,int low,int high,int [] key,char flag){
        if(flag == '+'){
            for(int k:key){
                if(BinarySearchBase(a,low,high,k)== -1)
                    System.out.printf("%3d",k);
            }
        }
        else{
            for(int k:key){
                if(BinarySearchBase(a,low,high,k)== k)
                    System.out.printf("%3d",k);
            }
        }
    }

    public static int BinarySearchBase(int []a,int low,int high,int key){
        if(low > high)            return -1;
        int mid = (low+high)/2;
        if        (key == a[mid]) return key;
        else if   (key < a[mid])  return BinarySearchBase(a,low,mid-1,key);
        else                      return BinarySearchBase(a,mid+1,high,key);
    }
}

