package CH1.CH1_3.ProblemList_Queue;


import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class TestCircleListQueue {
    public static void main(String[] args){
        String [] str = {"A","B","C","D","E","F","G","H"};
        CircleListQueue<String> q = new CircleListQueue<String>(str);
//        q.Print();
        q.dequeue();
        q.enqueue("ZZ");
        Iterator itor = q.iterator();
        while(itor.hasNext()){
            StdOut.printf("%3s -->",itor.next());
        }


    }


}
