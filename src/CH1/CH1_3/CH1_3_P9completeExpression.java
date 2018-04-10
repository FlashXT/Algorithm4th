/*Algorithm4th,CH1.3_P9,利用Stack进行表达式补全；
 *用户输入：1+2)*3-4)*5-6)))
 *Author：FlashXT;
 *Date:2018.4.10,Tuesday;
 * */
package CH1.CH1_3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class CH1_3_P9completeExpression {
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
            if(str2[i].equals("+")||str2[i].equals("-")||str2[i].equals("*")||str2[i].equals("/"))
                ops.push(str2[i]);
            else if (str2[i].equals(")"))
            {
                temp = vals.pop();temp2 = vals.pop();
                vals.push("("+temp2+ops.pop()+temp+str2[i]);
            }


            else vals.push(str2[i]);
            i++;

        }
        StdOut.println(vals.pop());
    }

}
