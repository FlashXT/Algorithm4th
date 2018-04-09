/*Algorithm4th,CH1.3,共变数组和类型擦除，以及泛型数组的问题；
 * Author:turboMan
 * Date:2018.4.4;
 * */
package Test;

import edu.princeton.cs.algs4.StdOut;

public class testCovariantarray_typeErasure {
    public static void main(String [] args){
        Object [] array = new String[10];
        array[0]="AAAAAA";
        array[1]=12345;
        StdOut.println(array[0]);
        StdOut.println(array[1]);
    }
}
