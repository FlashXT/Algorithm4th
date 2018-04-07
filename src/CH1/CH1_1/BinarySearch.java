/*BinarySearch循环版，需要在命令行编译运行：
*①javac-algs4 BinarySearch.java
*②java-algs4 BinarySearch TinyW.txt,然后输入key,进行查找
*③java-algs4 BinarySearch TinyW.txt < TinyT.txt ，进行查找
*/
package CH1.CH1_1;
import java.util.Arrays;
import edu.princeton.cs.algs4.*;
public class BinarySearch {
    public static void main(String args[]){
        int whitelist[]=In.readInts(args[0]);
        Arrays.sort(whitelist);
		while(!StdIn.isEmpty()){
			int key=StdIn.readInt();
			if(rank(key,whitelist)<0)
				StdOut.println(key);
		}
    }
    public static int rank(int key,int []a){

        int low=0;
        int high=a.length-1;
        int mid=(low+high)/2;
        while(low<high){
            if(key<a[mid]) high=mid-1;
            else if (key > a[mid]) low=mid+1;
            else return mid;
            mid=(low+high)/2;
        }
        return -1;
    }

}