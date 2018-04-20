package CH1.CH1_3.Bag;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Random;

public class testRandomBag  {
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5,6,7,8};
        RandomBag <Integer> rbag = new RandomBag<Integer>(arr);
        Iterator <Integer> itor = rbag.iterator();
        while(itor.hasNext())
            StdOut.printf("%3d",itor.next());
//        Random rand = new Random();
//        int i = 0;
//        int temp;
//        while( i < 10){
//             temp =  rand.nextInt(10);
//             StdOut.println(temp);
//             i++;
//        }


    }

}
