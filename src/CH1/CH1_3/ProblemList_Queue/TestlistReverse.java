package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;


public class TestlistReverse {
    public static void main(String [] args){
        Integer [] arr = {1,2,4,5,6,7,8,9,10};
        List <Integer> list = new List<Integer>(arr);
        Iterator <Integer>  itor = list.iterator();
        while(itor.hasNext())
            StdOut.printf("%2d-->",itor.next());
        StdOut.println();
        List.Node rlist = list.ReverseList(list.first);
        List.Node curr = rlist;

        while(curr != null ){
            StdOut.printf("%2d-->",curr.item);
            curr = curr.next;

        }
    }


}
