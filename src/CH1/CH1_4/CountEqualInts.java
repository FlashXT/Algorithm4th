/********************************************************************************
 *
 * CH1.4.8:计算输入文件中相等整数对的数量。如果第一个程序是平方阶的，请继续跪进为线性对数阶.
 * Author：FlashXT;
 * Date:2018.4.24,Tuesday;
 *
 * ******************************************************************************/

package CH1.CH1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class CountEqualInts {
    public static void main(String [] args){
        int [] data;
        System.out.println("Scale\tCount\tTime(N^2)\n--------------------------");
        for(int i = 1; i <= 32;i*=2){
            data= In.readInts("src\\CH1\\CH1_4\\"+i+"Kints.txt");
            Stopwatch stopwatch = new Stopwatch();
            StdOut.printf("%-2dk\t\t%-5d\t%-5.3fs\n",i,Count(data),stopwatch.elapsedTime());
        }

        System.out.println("Scale\tCount\tTime(NlgN)\n--------------------------");
        for(int i = 1; i <= 32;i*=2){
            data= In.readInts("src\\CH1\\CH1_4\\"+i+"Kints.txt");
            Stopwatch stopwatch = new Stopwatch();
            StdOut.printf("%-2dk\t\t%-5d\t%-5.3fs\n",i,Count2(data),stopwatch.elapsedTime());
        }

    }
    //双重循环，N^2阶，平方阶
    public static int Count(int [] data){
        int cnt = 0;
        for(int i = 0; i < data.length; i++)
            for(int j = i + 1; j < data.length; j++ )
                if(data[i]== data[j]) cnt++;
        return cnt;
    }
    //单重循环，NlgN阶，线性对数阶
    public static int Count2(int [] data){
        int cnt = 0;
        Arrays.sort(data);
        for(int i = 0; i < data.length; i++)

                if(i != BinarySearch(data,data[i])) cnt++;
        return cnt;
    }

    public static int BinarySearch(int []a,int key){

        int low = 0;
        int high = a.length - 1;

        while(low <= high){
            int mid = ( low + high ) / 2;
            if( key < a[mid] )           high = mid - 1;
            else if (key > a[mid])        low = mid + 1;
            else                          return mid;

        }
        return -1;
    }
}
