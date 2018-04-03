/*Algorithm4th,CH1.2.2,回文字符串判定；
* Author:turboMan
* Date:2018.4.3;
* */
package CH1.CH1_2;

import edu.princeton.cs.algs4.StdOut;

public class CircularRotation {
    public static void main(String [] args){
        String str = "ABCDEFGHIGK";
        String str2 = cirRotation(str,4);
        StdOut.println(cirJudge(str,str2));

    }
    public static boolean cirJudge(String str1,String str2){
        String temp="";
        for(int i = 0; i < str2.length(); i++){
            temp=cirRotation(str2,i);
            if(str1.equals(temp))  return true;

        }
        return false;
    }
    public static String cirRotation(String str,int n){
        if(n>str.length()) return str;
        str=str.substring(n,str.length())+str.substring(0,n);
        return str;
    }
}
