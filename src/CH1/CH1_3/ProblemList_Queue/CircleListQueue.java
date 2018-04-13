package CH1.CH1_3.ProblemList_Queue;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircleListQueue <Item> implements Iterable<Item>  {


    private Node first;
    private Node last;
    private int N;

    private class Node{
        Item item;
        Node next;
        public Node(){}
        public Node(Item item){
            this.item = item;
            this.next = null;
        }
    }


    public CircleListQueue(){
        Node node = new Node();
        first = node;
        last = node;
        last.next = first;
        N = 0;
    }
    public CircleListQueue(Item [] item){
        Node node = new Node();
        first = node;
        last = node;
        last.next = first;
        N = 0;
    }
    //添加元素尾插法
    public  void enqueue(Item item){
         if(first == last) first.item = item;
         else if(last.next == first)
              throw  new RuntimeException("The Queue is full!");
         else{
             last = last.next;
             last.item = item;
             N++;
         }
    }

    //迭代
    public Iterator<Item> iterator()
    {
        return new CircleQueueIterator();
    }

    private class CircleQueueIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
