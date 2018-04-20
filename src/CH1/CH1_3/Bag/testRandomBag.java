/*Algorithm4th,CH1.3_P34,测试RandomBag
 *Author：FlashXT;
 * Date:2018.4.19,Thursday;
 * */

package CH1.CH1_3.Bag;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class testRandomBag  {
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5,6,7,8,9,10};
        RandomBag <Integer> rbag = new RandomBag<Integer>(arr);

        StdOut.println(rbag.inBag(10));
        rbag.Delete(10);
        StdOut.println(rbag.inBag(10));
        Iterator <Integer> itor = rbag.iterator();
        while(itor.hasNext())
            StdOut.printf("%5d",itor.next());
    }

}
