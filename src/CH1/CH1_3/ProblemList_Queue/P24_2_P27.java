package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class P24_2_P27 {

    public static void main(String [] args) {
        Integer [] a = {1,2,3,7,5};
        List<Integer> list =new List<Integer>(a);

//       removeAfter(list,15);

//        remove(list,7);

        //P1.3.25
        list.Insert(5,100);
        int [] array = new int [list.size()] ;
       // list2Array(list,array);
        //for(int temp : array)StdOut.printf("%-5d",temp);
        StdOut.println( max(list));
       //迭代器定义的位置若在操作之前，则不会呈现操作结果
//        Iterator<Integer > listitpr = list.iterator();
//        while(listitpr.hasNext()){
//            StdOut.printf("%-5d",listitpr.next());
//        }

    }
    //P1.3.24
    public static void removeAfter(List list,int key){
        if((int)list.getFirst() == key ) list.removeFirst();
        else if((int)list.getLast() == key)list.removeLast();
        else list.Delete(key);


    }

    //P1.3.26
    public static void remove (List list ,int key){
        int N = list.size();
        while( N > 0)
        {
            list.Delete(key);
            N--;
        }
    }

    //P1.3.27
    public static int max(List list){
        int max =0;int temp;
        Iterator<Integer > itor = list.iterator();

        while(itor.hasNext()){
             temp = itor.next();
            if(max < temp ) max =temp;
        }
        return max;
    }

}
