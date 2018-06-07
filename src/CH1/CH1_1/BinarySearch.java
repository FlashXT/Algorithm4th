/*BinarySearch循环版，需要在命令行编译运行：
*①javac-algs4 BinarySearch.java
*②java-algs4 BinarySearch TinyW.txt,然后输入key,进行查找
*③java-algs4 BinarySearch TinyW.txt < TinyT.txt ，进行查找
*/
package CH1.CH1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
public class BinarySearch {
    public static void main(String args[]){
        int whitelist[]=In.readInts(args[0]);
        Arrays.sort(whitelist);
        for(int s:whitelist)
            StdOut.print(s+" ");
        StdOut.println();
		while(!StdIn.isEmpty()){
			int key=StdIn.readInt();
			StdOut.println(rank(whitelist,key));
		}
    }
    public static int rank(int []a,int key){

        int low = 0;
        int high = a.length - 1;
        int mid = low + ( high - low ) / 2;
        while(low <= high){

            if( key < a[mid] )           high = mid - 1;
            else if (key > a[mid])        low = mid + 1;
            else                          return mid;
            mid = low + ( high - low ) / 2;
        }
        return -1;
    }

}
