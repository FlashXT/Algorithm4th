/***********************************************************************
 * 题目：用两个Stack实现Queue；
 * 算法分析：将所有元素压入栈再弹出，元素的顺序就颠倒了，再次重复这个工程，元素的顺序
 *         就会复原。
 *
 * Author:FlashXT;Date:2018.5.8,Tuesday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 ***********************************************************************/


package CH1.CH1_4.CH1_4_27_31_QueueAndStack;


import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class QueueByStack<Item> implements Iterable<Item>{

   private   ListStack< Item> ls0;
   private   ListStack<Item> ls1;
    public QueueByStack(){
        ls0 = new ListStack<Item>();
        ls1 = new ListStack<Item>();
    }

    //入队
    public  void  enqueue(Item item){
        ls0.push(item);
    }
    //出队
    public  Item  enqueue(){
        Item temp;
        while(!ls0.isEmpty()){
            temp = ls0.pop();
            ls1.push(temp);
        }
        Item temp1= ls1.pop();
        while(!ls1.isEmpty()){
            temp = ls1.pop();
            ls0.push(temp);
        }
        return temp1;
    }

    public boolean isEmpty(){
        return ls0.isEmpty();
    }
    public int size(){
        return ls0.size();
    }
    public Item peek(){
        Item temp;
        while(!ls0.isEmpty()){
            temp = ls0.pop();
            ls1.push(temp);
        }
        Item temp1= ls1.peek();
        while(!ls1.isEmpty()){
            temp = ls1.pop();
            ls0.push(temp);
        }
        return temp1;
    }

    public Iterator<Item> iterator(){
        Item temp;
        while(!ls0.isEmpty()){
            temp = ls0.pop();
            ls1.push(temp);
        }
        return  ls1.iterator();
    }

    public void Traveral(){
        Iterator<Item> itor = this.iterator();
        while(itor.hasNext()){
            Item item = itor.next();
            ls0.push(item);
            StdOut.print(item+" ");
        }
    }

    public static void main(String [] args){

        QueueByStack<String > queue = new QueueByStack<String>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        StdOut.println(queue.size());
        queue.Traveral();
        StdOut.println("\n"+queue.size());
        StdOut.println( queue.peek());


    }




}
