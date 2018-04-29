package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class TestRandomQueue {
    public static void main(String [] args){
        Integer arr[] = {1,2,3,4,5,6,7,8,9,10};
        RandomQueue<Integer> rq = new RandomQueue<Integer>(arr);
        rq.Print();
        StdOut.println();
        StdOut.println(rq.dequeue());
        rq.enqueue(100);
        rq.enqueue(18);
        StdOut.println(rq.sample());
        Iterator<Integer> itor = rq.iterator();
        while(itor.hasNext()){
            StdOut.printf("%-4d",itor.next());

        }

    }

}
