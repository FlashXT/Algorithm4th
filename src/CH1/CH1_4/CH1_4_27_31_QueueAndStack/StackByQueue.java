/**********************************************************************************
 * 题目：利用一个队列实现的栈。使用一个队列实现一个栈，使得每个栈操作所需的队列操作数量为线性级别。
 *
 * Author:FlashXT;Date:2018.5.9,Wednesday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 */





package CH1.CH1_4.CH1_4_27_31_QueueAndStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class StackByQueue<Item> implements Iterable<Item> {
    private ListQueue<Item> queue ;
    public StackByQueue(){
        queue = new ListQueue<Item>();
    }

    //入栈
    public  void push(Item item){
        queue.enqueue(item);
    }
    //出栈
    public Item pop(){
        Item item;
        for(int i = 1; i< queue.size();i++ ){
            item = queue.dequeue();
            queue.enqueue(item);
        }
        item = queue.dequeue();

        return item;

    }
    //获取栈顶元素
    public Item peek(){
        Item item;
        for(int i = 1; i< queue.size();i++ ){
            item = queue.dequeue();
            queue.enqueue(item);
        }
        item = queue.dequeue();
        queue.enqueue(item);

        return  item;
    }

    public int size(){
        return queue.size();
    }
    //迭代器实现不完美，顺序有问题，考虑使用递归实现
    public Iterator<Item> iterator(){

        return queue.iterator();
    }
    public void Traveral(){
        Iterator<Item> itor = this.iterator();

        while(itor.hasNext()){
            StdOut.print(itor.next()+" ");
        }
        StdOut.println();
    }
    public static void main(String [] args){

        StackByQueue<Integer> qstack = new StackByQueue<Integer>();
        qstack.push(1);
        qstack.push(2);
        qstack.push(3);
        qstack.push(5);
        StdOut.println(qstack.size());
        StdOut.println(qstack.peek());

        qstack.Traveral();

        StdOut.println(qstack.size());


    }

}
