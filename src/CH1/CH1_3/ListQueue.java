/*Algorithm4th,CH1.3,利用链表实现Queue
 *Author：FlashXT;
 * Date:2018.4.7,Saturday;
 * */
package CH1.CH1_3;

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
}
