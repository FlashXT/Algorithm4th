/*Algorithm4th,CH1.3_P10,利用Stack生成后序表达式；
 *用户输入：( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * 预期输出：1 2 3 + 4 5 * * +
 *Author：FlashXT;
 *Date:2018.4.10,Tuesday;
 * */
/*解题思路：
*可以采用 Dijkstra 发明的“双栈法”：
*    将操作数压入操作数栈；
*    将运算符压入运算符栈；
*    忽略左括号；
*    在遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将预算结果压入操作数栈。
*    摘自《算法（第四版）中文版》 P79
*
*双栈法分析：
*   将操作数和运算符分类，压入不同的栈；
*   忽略左括号；
*   将右括号作为一个标志，每当遇到右括号，就弹出数据，进行处理；
*   这里的处理可以是对数值进行计算，也可以是其他的处理方法，比如本题中对字符串进行链接
*    处理，之后，将处理结果压入操作数栈；
*
* 本题思路：
*   遇到数字就压入操作数栈，
*   遇到运算符就压入运算符栈；
*   遇到右括号，就弹出两个操作数和一个运算符，进行字符串链接（与P9的顺序稍加改变），而后作为一个字符串（整体）
*     重新压入操作数栈；
*   由于栈中内容是反的，所以在字符串链接以及最后输出结果时都要额外处理一下，具体见代码。
* */
package CH1.CH1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class CH1_3_P10_InfixToPostfix {
    public static void main(String[] args){
        Stack<String> ops = new Stack<String>();
        Stack<String> vals = new Stack<String>();
        StdOut.printf("请输入计算表达式：");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        StdOut.println(str);
        String [] str2 = new String[str.length()];
        for(int i = 0 ;i < str.length();i++) str2[i] = String.valueOf(str.charAt(i));

        int i=0;
        String temp,temp2;
        while(i < str2.length){
            if(str2[i].equals("(")||str2[i].equals(" ")) ;
            else if(str2[i].equals("+")||str2[i].equals("-")||str2[i].equals("*")||str2[i].equals("/"))
                       ops.push(str2[i]);
            else if (str2[i].equals(")"))
            {
                temp = vals.pop();temp2 = vals.pop();
                vals.push(temp2+" "+temp+" "+ops.pop());
            }


            else vals.push(str2[i]);
            i++;

        }
        StdOut.println(vals.pop());
    }

}
