/*Algorithm4th,CH1.3_P4,利用Stack进行括号匹配；
 *用户输入：
 *Author：FlashXT;
 *Date:2018.4.9,Monday;
 * */

package CH1.CH1_3.StackApplication;

import CH1.CH1_3.Stack.ListStack;
import CH1.CH1_3.Stack.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Scanner;

public class CH1_3_P4MatchBrackets {

        public static void main(String [] args){
            ListStack<Character> s = new ListStack<Character>();

            StdOut.printf("请输入括号串：");
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            char [] str2 = new char[str.length()];
            for(int j =0;j < str.length();j++) str2[j] = str.charAt(j);
           // String [] str2 = str.split(" ");
            int i = 0,k = 0;char rbrackets;
            while(i < str2.length){
                if(str2[i]=='('||str2[i]=='{'||str2[i]=='['){
                    StdOut.println("入栈："+str2[i]);
                    s.push(str2[i]);
                }

                else  {
                    if(str2[i]==')'){
                        rbrackets = s.pop();
                        if(rbrackets=='(') ;
                        else s.push(rbrackets);
                    }
                    else if(str2[i]==']'){
                        rbrackets = s.pop();
                        if(rbrackets=='[') ;
                        else s.push(rbrackets);
                    }
                    else{
                        rbrackets = s.pop();
                        if(rbrackets=='{') ;
                        else s.push(rbrackets);
                    }
                }
                StdOut.println("====================================");
                StdOut.println("栈中内容：");
                Iterator<Character> iterator = s.iterator();
                k = 0;
                while(iterator.hasNext()){
                    StdOut.printf("%s ",iterator.next());
                    k++;
                }
                for(;k<7;k++) StdOut.printf("\t");
                StdOut.printf("栈长度：%s",s.size());
                StdOut.println("\n------------------------------------");
                i++;

            }
            if(s.isEmpty()) StdOut.println("True");
            else StdOut.println("False");

        }
}
