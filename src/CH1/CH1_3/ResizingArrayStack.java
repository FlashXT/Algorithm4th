//可迭代的栈的实现
package CH1.CH1_3;

import java.util.Iterator;
public class ResizingArrayStack<Item> implements Iterable<Item>  {
    private Item[] a = (Item [])new Object[1];
    private int N = 0;

    public ResizingArrayStack(){}

    public boolean isEmpty(){return N == 0;}

    public int size() {return N;}

    private void resize(int max){
        //将栈移动到一个大小为max的新数组
        Item [] temp = (Item []) new Object[max];
        for(int i = 0; i < N;i++)
            temp[i] = a[i];
        a=temp;
    }
    public void push(Item item){
        //入栈
        if(N == a.length) resize(2*a.length);
        a[N++]=item;
    }

    public Item pop() throws Exception{
        //出栈
        if(!this.isEmpty()){
             Item item = a[--N]; a[N] = null;
             if(N == a.length/4) resize(a.length/2);
             return item;
        }
         else
             throw  new Exception("Stack is empty!");
    }

    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        //支持栈的迭代
        private int i = N;
        public boolean hasNext(){return i > 0;}
        public Item next(){return a[--i];}
        public void remove(){}
    }
}
