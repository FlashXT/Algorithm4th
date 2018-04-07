/*Algorithm4th,CH1.3,利用链表实现Stack
 *Author：FlashXT;
 * Date:2018.4.6,Friday;
 * */
package CH1.CH1_3;

import java.util.Iterator;

public class ListStack<Item> implements  Iterable<Item> {
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;

    }
    public ListStack(){
//        Node node = new Node();
//        first = node;
    }
    public boolean isEmpty(){return first == null;}
    public int size(){return N;}
    //入栈
    public void push(Item item){
//        Node node = new Node();
//        node.item = item;
//        node.next = first.next;
//        first.next = node;

        Node node = first;
        first = new Node();
        first.item = item;
        first.next = node;
        N++;
    }
    //出栈
    public Item pop(){
        Item item = first.item;
        first = first.next;
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