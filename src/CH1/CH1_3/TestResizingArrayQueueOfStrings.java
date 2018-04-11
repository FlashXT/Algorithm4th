package CH1.CH1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Scanner;

public class TestResizingArrayQueueOfStrings {
    public static void main(String [] args) throws Exception{
        ResizingArrayQueueOfStrings<String> q = new  ResizingArrayQueueOfStrings<String>();
        StdOut.printf("请输入字符串：");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String [] str2 = str.split(" ");
        int i = 0;
        int k = 0;
        while(i < str2.length){
            if(!str2[i].equals("-")){
                StdOut.println("入队："+str2[i]);
                q.enqueue(str2[i]);
            }

            else  {
                StdOut.println("出队："+q.dequeue());
            }
            StdOut.println("=========================================");
            StdOut.println("队列中的内容：");
            Iterator<String> iterator = q.iterator();
            k = 0;
            while(iterator.hasNext()){
                StdOut.printf("%s ",iterator.next());
                k++;
            }

            for(;k<8;k++) StdOut.printf("\t");
            StdOut.printf("队列长度：%s",q.size());
            StdOut.println("\n=========================================");
            i++;

        }

    }
}
