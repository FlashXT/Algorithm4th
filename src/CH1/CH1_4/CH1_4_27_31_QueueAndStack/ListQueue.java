/*Algorithm4th,CH1.3,利用链表实现Queue
 *Author：FlashXT;
 * Date:2018.4.7,Saturday;
 * */
package CH1.CH1_4.CH1_4_27_31_QueueAndStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ListQueue<Item> implements  Iterable<Item>  {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){         return first == null;    }
    public int size(){return N;}
    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }
    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;

    }
    //获取队头元素
    public Item peek(){
        if(isEmpty()) throw new RuntimeException("Stack underflow");
        return first.item;
    }
    //迭代
    public Iterator<Item> iterator(){ return new ListIterator();}
    private class ListIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){   return current != null;}
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){}
    }


//    public static void main(String [] args){
//        ListQueue<Integer> lqueue = new ListQueue<Integer>();
//        lqueue.enqueue(1);
//        lqueue.enqueue(2);
//        lqueue.enqueue(3);
//        lqueue.enqueue(4);
//        lqueue.dequeue();lqueue.dequeue();lqueue.dequeue();
//
//        StdOut.println(lqueue.peek());
//
//    }
}
