/*Algorithm4th,CH1.3,创建一个栈并根据用户输入中的指示压入或弹出字符串；
 *用户输入：to be or not to - be - - that - - - is
 *Author：FlashXT;
 *Date:2018.4.6,Friday;
 * */
package CH1.CH1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Scanner;

public class TestListStack {
    public static void main(String [] args){
        ListStack<String> s = new ListStack<String>();

        StdOut.printf("请输入字符串：");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String [] str2 = str.split(" ");
        int i = 0,k = 0;
        while(i < str2.length){
            if(!str2[i].equals("-")){
                StdOut.println("入栈："+str2[i]);
                s.push(str2[i]);
            }

            else  {
                StdOut.println("出栈："+s.pop());
            }
            StdOut.println("====================================");
            StdOut.println("栈中内容：");
            Iterator<String> iterator = s.iterator();
            k = 0;
            while(iterator.hasNext()){
                StdOut.printf("%s ",iterator.next());
                k++;
            }
            for(;k<8;k++) StdOut.printf("\t");
            StdOut.printf("栈长度：%s",s.size());
            StdOut.println("\n====================================");
            i++;

        }

    }
}
