package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class CircleArrayQueue<Item> implements Iterable<Item> {
    private int tail;
    private int top;

    //Object数组，然后强制转型
    private Item [] queue = (Item[]) new Object[10];
    public CircleArrayQueue(){
       top = 0;
       tail = 0;
    }
    public CircleArrayQueue(Item [] item){
        for(int i =0 ; i < item.length; i++)
            enqueue(item[i]);
    }
    public boolean isFull(){
        return (tail+1)%queue.length == top;
    }
    public boolean isEmpty(){
       return top == tail;
    }

    public void enqueue(Item item){
        if(isFull())
        {StdOut.println("The Queue is FUll!!");
         return ;
        }
        else {

            queue[tail] = item;
            tail = (tail+1)%queue.length;
        }
    }
    public Item dequeue(){
        if(isEmpty())
        {StdOut.println("The Queue is EMPTY!!");
            return  null;
        }
        else{
            Item item = queue[top];
            top = (top+1)%queue.length;
            return item;
        }
    }
    public Item peek(){
        return queue[top];
    }

    //迭代
    public Iterator<Item> iterator(){ return new CircleArrayIterator();}
    private class CircleArrayIterator implements Iterator<Item>{
        private int i = top;
        public boolean hasNext(){return i != tail;}
        public Item next(){
            Item item =  queue[i];
            i = (i+1)%queue.length;
            return item;
        }
        public void remove(){}
    }
}
