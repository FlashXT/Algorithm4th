package CH1.CH1_4.CH1_4_27_31_QueueAndStack;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/*******************************************************************************************
 *题目：一个栈和一个steque实现的双端队列。使用一个栈和steque实现一个双向队列，使得双向队列的每个操作所需的
 *     栈和steque操作均摊后为一个常数。
 *
 *分析：steque 作为队列的头部，stack 作为队列的尾部。
 *     pushLeft：直接 push 到 steque 中即可。
 *     pushRight：如果 stack 为空，则直接 enqueue 到 steque 中，否则就 push 到 stack 中。
 *     popLeft：如果 steque 为空，则将 stack 中的元素倒到 steque 中去（steque.push(stack.pop())），
 *     然后再从 steque 中 pop。
 *     popRight：如果 stack 为空，则将 steque 中的元素倒到 stack 中去，然后再从 stack 中 pop。
 *
 *Author:FlashXT;Date:2018.5.9,Wednesday;
 *CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *******************************************************************************************/
public class DualQueueByStackSteque<Item>  {
    private Steque<Item> steque;
    private ListStack<Item> stack;
    public DualQueueByStackSteque(){

        steque = new Steque<Item>();
        stack = new ListStack<Item>();
    }
    public void pushLeft(Item item){
        steque.push(item);
    }
    public void pushRight(Item item){
        if(stack.isEmpty())steque.enqueue(item);
        else   stack.push(item);
    }
    public Item popLeft(){
        if(steque.isEmpty())
            while(!stack.isEmpty()){
                steque.push(stack.pop());
            }

            return steque.pop();

    }

    public Item popRight(){
        if(stack.isEmpty())

            while(!steque.isEmpty()){
                stack.push(steque.pop());
            }

            return  stack.pop();
    }
    public int size(){
        return steque.size()+stack.size();
    }
    public void Traveal(){
        int num = 0; Item item;
        if(stack.isEmpty()){
            Iterator<Item> itor = steque.iterator();
            while(itor.hasNext()){
                StdOut.print(itor.next()+" ");
            }
            StdOut.println();
        }
        else{
            if(steque.isEmpty()){
                num = stack.size();
                while(!stack.isEmpty()){
                    steque.push(stack.pop());
                }
                while(num > 0 ){
                    item = steque.pop();
                    StdOut.print(item+" ");
                    stack.push(item);
                    num--;
                }
            }
            else{
                num = steque.size();
                while(!steque.isEmpty()){
                    item = steque.pop();
                    stack.push(item);
                }
                StdOut.println(stack.size());
                while(num > 0 ){
                    item = stack.pop();
                    StdOut.print(item+" ");
                    steque.push(item);
                    num--;
                }

                num = stack.size();
                while(!stack.isEmpty()){
                    steque.push(stack.pop());
                }
                while(num > 0 ){
                    item = steque.pop();
                    StdOut.print(item+" ");
                    stack.push(item);
                    num--;
                }

            }
        }

    }
    public static void main(String [] args){

        DualQueueByStackSteque<Integer> dq = new DualQueueByStackSteque<Integer>();
        dq.stack.push(1); dq.stack.push(2); dq.stack.push(3);
        dq.steque.push(4);dq.steque.push(5);dq.steque.push(6);
       // StdOut.println(dq.size());
        dq.Traveal();
    }

 }
