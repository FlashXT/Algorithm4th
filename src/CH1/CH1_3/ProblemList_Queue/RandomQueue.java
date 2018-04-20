package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Random;

public class RandomQueue<Item> implements Iterable<Item> {
    private Item[] queue = (Item []) new Object[10];
    private int top = 0;
    private int tail = 0;

    //创建一条空队列
    public RandomQueue(){ top = 0; tail = 0;}
    public RandomQueue(Item [] item){
           for(int i = 0; i < item.length; i++)
            enqueue(item[i]);
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return top == tail;
    }
    //入队
    public void enqueue(Item item){
        if(tail - top == queue.length ) throw new RuntimeException("THE QUEUE IS FULL!");
        queue[tail++] = item;

    }
    //删除并随机返回一个元素（取样且不放回）
    public Item dequeue(){
        if(isEmpty() ) throw new RuntimeException("THE QUEUE IS EMPTY!");
        Random rand = new Random();
        int temp = rand.nextInt((int)(Math.random()*(tail - top)) + top+1);
        Item item = queue[temp];
        queue[temp] = queue[--tail] ;

        return item;


    }
    //随机返回一个元素但不删除它（取样且放回）
    public Item sample(){
        Random rand = new Random();
        int temp = rand.nextInt((int)(Math.random()*(tail - top)) + top+1);

        return queue[temp];
    }
    //Print
    public void Print(){
        for(int i = top; i < tail; i++)
            StdOut.printf("%-4s",queue[i].toString());
    }

    //迭代
    public Iterator<Item> iterator(){return new RandomQueueIterator();}
    private class RandomQueueIterator implements Iterator<Item>{
        private  int [] flag = new int[queue.length];
        int num = 0;
        Random rand = new Random();


        public boolean hasNext(){

            return num != tail - top;
        }
        public Item next(){
            Random rand = new Random();
            int temp = rand.nextInt((int)(Math.random()*(tail - top)) + top+1);

            while(flag[temp] == 1){
                temp = rand.nextInt((int)(Math.random()*(tail - top)) + top+1);

            }
            num++;
            flag[temp] = 1;
            return  queue[temp];

        }
        public void remove(){}
    }

}
