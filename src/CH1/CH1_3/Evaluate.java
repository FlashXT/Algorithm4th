/*Algorithm4th,CH1.3,利用Stack进行表达式计算；
 * Author:turboMan
 * Date:2018.4.4;
 * */
package CH1.CH1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class Evaluate {

    public static void main(String[] args){
        Stack<Character> ops = new Stack<Character>();
        Stack<Double> vals = new Stack<Double>();
        StdOut.printf("请输入计算表达式：");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StdOut.println(str);
        int i=0;
        char ch;
        while(i < str.length()){
            ch = str.charAt(i);
            if(ch == '(') ;
            else if (ch == '+'|| ch == '-'|| ch == '*'|| ch == '/') ops.push(ch);
            else if(ch == ')')
            {
                char op=ops.pop();
                double v1=vals.pop();
                double v2=vals.pop();
                if (op == '+')         vals.push(v1+v2);
                else if (op == '-')    vals.push(v1-v2);
                else if (op == '*')    vals.push(v1*v2);
                else if (op == '/')    vals.push(v1/v2);
            }
            else vals.push((double)ch-48);
            i++;

        }
        StdOut.println(vals.pop());
    }

}
