package CH1.CH1_3.ProblemList_Queue;

public class TestDoubleLinkedList {
    public static void main(String [] args){
        Integer [] arr = {1,2,3,4,5,6,7,8,9};

        DoubleLinkedList<Integer>  dlist = new DoubleLinkedList<Integer>(arr);
        dlist.InsertNode(4,100,false);
        dlist.Print(true);
        dlist.DeleteNode(1);
        dlist.Print(true);
        dlist.DeleteNode(100);
        dlist.Print(true);
        dlist.DeleteNode(9);
        dlist.Print(true);
//        dlist.Print(false);

//        Iterator<Integer> itor = dlist.iterator();
//        while(itor.hasNext()){
//            StdOut.printf("%s--> ",itor.next());
//        }
//        StdOut.println();

    }

}
