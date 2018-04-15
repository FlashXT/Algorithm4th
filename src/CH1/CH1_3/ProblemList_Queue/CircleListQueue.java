/*Algorithm4th,CH1.3.3_P29,利用链表实现环形队列；
* Author：FlashXT;
* Date:2018.4.14,Saturday*/
package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class CircleListQueue <Item> implements Iterable<Item>  {
    private Node first;
    private Node last;
    private int N;
    private class Node{
        private Item item;
        private Node next;
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
        for(int i = 0 ; i < item.length; i++)
          enqueue(item[i]);
    }
    //添加元素头插法
    public  void enqueue(Item item){
        if(isEmpty()) first.item = item;
        else {
            Node node = new Node();
            node.item = item;
            node.next = first;

            first = node;
            last.next = first;
        }
        N++;


    }
    //删除元素尾部出队
    public Item  dequeue(){
        Item item = last.item;
        Node curr = first;
        while(curr.next!= last){

            curr = curr.next;
        }


        curr.next = last.next;
        last = curr;
        N--;
        return item;
    }
    //判断队列是否为空
    public boolean isEmpty(){return  N==0;}
    //获取队头元素
    public Item peek(){return last.item;}

    //输出队列内容
    public void Print(){
        Node curr = first;

        while(curr!= last){

            StdOut.printf("%s",curr.item);
            curr = curr.next;

        }
        StdOut.printf("%s",curr.item);
    }

    //迭代

    public Iterator<Item> iterator(){ return new CircleQueueIterator();}
    private class CircleQueueIterator implements Iterator<Item>{

        private int n = N;
        private Node current = last;

        public boolean hasNext()  { return n > 0; }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.next.item;
            current = current.next;
            n--;
            return item;
        }
    }

}
