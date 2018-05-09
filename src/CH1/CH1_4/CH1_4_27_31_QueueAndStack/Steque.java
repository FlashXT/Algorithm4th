package CH1.CH1_4.CH1_4_27_31_QueueAndStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/***************************************************************************************
 * 题目：一个以栈为目标的队列（steque）,是一种支持push、pop和enqueue操作的数据类型。
 * 为这种抽象数据类型定义一份API并给出一份基于链表的实现。
 *
 *                                      Steque API
 *              -------------------------------------------------------------
 *                  public class Steque<Item> implements Iterable<Item>
 *              -------------------------------------------------------------
 *                   int size()                  steque的元素数量
 *              -------------------------------------------------------------
 *                  void push()                  向steque中压入一个元素（队头）
 *              -------------------------------------------------------------
 *                  Item pop()                   从steque中弹出一个元素
 *              -------------------------------------------------------------
 *                  void enqueue()               向steque中压入一个元素（队尾）
 *              -------------------------------------------------------------
 *               boolean isEmpty()               判断steque是否为空
 *              -------------------------------------------------------------
 *                  Item peek()                  返回steque队头元素
 *              -------------------------------------------------------------
 *
 * Author:FlashXT;Date:2018.5.9,Wednesday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 * ****************************************************************************************/
public class Steque<Item> implements Iterable<Item> {

    private class Node{
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    private int N;


    public Steque(){

        first = null;
        last = null;
        first = last;

        N = 0;
    }

    // 向steque中压入一个元素（队头）
    public void push(Item item){

            Node node = new Node();
            if(N==0) last= node;
            node.item = item;
            node.next = first;
            first = node;

        N++;
    }
    // 向steque中压入一个元素（队尾）
    public void enqueue(Item item){

            Node node = new Node();
            node.item = item;
            last.next =node ;
            node.next = null;

        N++;
    }
    //从steque中弹出一个元素
    public Item pop(){
        if(isEmpty()) throw new RuntimeException("The Steque is Empty!");
        else{
            Item item = first.item;
            first= first.next;
            N--;
            return item;
        }
    }
    //返回栈顶元素
    public Item peek(){
        return  first.item;
    }

    public int size(){
        return N;
    }

    //isEmpty()
    public boolean isEmpty(){
        return N == 0;
    }


    public Iterator<Item> iterator() {   return new stequeiterator(); }

    public class stequeiterator implements Iterator<Item>{
        private Node curr= first;

        public boolean hasNext(){    return curr != null;   }
        public Item next(){
            Item item = curr.item;
            curr = curr.next;
            return item;
        }
        public void remove(){}

    }
    public static void main(String [] args){
      Steque<Integer> steque = new Steque<Integer>();
      steque.push(1);steque.push(2);steque.push(3);
      steque.enqueue(4);
      steque.pop();
      StdOut.println(steque.size());
      Iterator<Integer> itor = steque.iterator();
      while(itor.hasNext())
      {
          StdOut.print(itor.next()+" ");
      }
      StdOut.println();
    }
}
