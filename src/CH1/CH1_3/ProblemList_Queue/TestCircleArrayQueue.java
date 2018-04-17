package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class TestCircleArrayQueue {

    public static void main(String[] args){
        String [] str = {"A","B","C","D","E","F","G","H"};
        CircleArrayQueue<String> q = new CircleArrayQueue<String>(str);

        q.dequeue();
        q.dequeue();
        q.dequeue();


        q.enqueue("2A");
        q.enqueue("2B");
        q.enqueue("2C");


        q.enqueue("ZZ");
        q.Print();
        StdOut.println();
        Iterator itor = q.iterator();
        while(itor.hasNext()){
            StdOut.printf("%s-->",itor.next());
        }


    }
}
