package CH1.CH1_3;

import java.util.Iterator;

public class ResizingArrayQueueOfStrings<Item> implements Iterable<Item>{
    private Item [] q = (Item []) new Object[1];
    private int N = 0;
    public ResizingArrayQueueOfStrings (){}
    public boolean isEmpty(){return N == 0;}
    public void enqueue(Item item){
        if(N == q.length) resize(2*q.length);
         q[N++] = item;
    }
    public Item dequeue()throws Exception {
        Item item = q[0];
        if (!this.isEmpty()) {
            for (int i = 0; i < q.length - 1; i++)
                q[i] = q[i + 1];
            N--;
            if (N < q.length / 2) resize(q.length / 2);
            return item;
        } else
            throw new Exception("Stack is empty!");
    }

    //获取队头元素
    public Item peek(){
        if(isEmpty()) throw new RuntimeException("Stack underflow");
        return q[0];
    }
    public int size(){return N;}
    //迭代
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        //支持队列的迭代
        private int i = 0;
        public boolean hasNext(){return i < N;}
        public Item next(){return q[i++];}
        public void remove(){}
    }
    public void resize(int length){
        Item [] temp = (Item [])new Object[length];
        for(int i = 0 ;i < N ;i++ )
            temp[i] = q[i];
        q = temp;
    }

}
