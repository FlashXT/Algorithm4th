package CH1.CH1_4.CH1_4_27_31_QueueAndStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/***************************************************************************************
 * 题目：两个栈实现steque,使得每个steque操作所需的栈操作均摊后为一个常数。
 *      steque的API如下：
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
 * ***************************************************************************************/

public class StequeBytwoStack<Item> implements Iterable<Item> {
    private   ListStack< Item> ls0;
    private   ListStack<Item> ls1;
    public StequeBytwoStack(){
        ls0 = new ListStack<Item>();
        ls1 = new ListStack<Item>();
    }
    //返回Steque的元素个数
    public int size(){
        return ls0.size();
    }
    //push
    public void push(Item item){

        ls0.push(item);
    }
    //pop
    public Item pop(){
       return ls0.pop();
    }
    //enqueue
    public void enqueue(Item item){
        int k = ls0.size();
        for(int i = 0 ; i < k;i++){
            ls1.push(ls0.pop());
        }
        ls0.push(item);
        for(int i = 0 ; i < k;i++){
            ls0.push(ls1.pop());
        }
    }
    //isEmpty
    public boolean isEmpty(){
        return ls0.isEmpty();
    }
    //peek()
    public Item peek(){
        return ls0.peek();
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

        StequeBytwoStack<Integer> sbs = new StequeBytwoStack<Integer>();
        sbs.push(1);sbs.push(2);sbs.push(3);sbs.push(4);
        StdOut.println(sbs.size());
        sbs.pop();
        StdOut.println(sbs.size());
        sbs.enqueue(5);
        sbs.Traveral();

    }
}
