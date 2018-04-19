package CH1.CH1_3.Bag;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class testRandomBag  {
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5,6,7,8};
        RandomBag <Integer> rbag = new RandomBag<>();
        Iterator <Integer> itor = rbag.iterator();
        while(itor.hasNext())
            StdOut.printf("%3d",itor.next());
    }

}
