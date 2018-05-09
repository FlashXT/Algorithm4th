/*Algorithm4th,CH1.3,利用链表实现Stack
 *Author：FlashXT;
 * Date:2018.4.6,Friday;
 * */
package CH1.CH1_4.CH1_4_27_31_QueueAndStack;

import java.util.Iterator;

public class ListStack<Item> implements  Iterable<Item> {
    private Node first;
    private int N;
    //私有嵌套类的一个特点是只有包含它的类能够直接访问它的实例变量，
    //因此无需将它的实例变量声明为public 或者private;
    private class Node{
        Item item;
        Node next;

    }
//    public ListStack(){
//        Node node = new Node();
//        first = node;
//    }
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
    //获取栈顶元素
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
}
