package CH1.CH1_3.ProblemList_Queue;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<Item> implements Iterable<Item>{

    private DoubleNode first;
    private DoubleNode last;

    private class DoubleNode{
      Item item;
      private DoubleNode prev;
      private DoubleNode next;
      public DoubleNode(){}
      public DoubleNode(Item item){this.item = item;}
    }

    public DoubleLinkedList (){
        first = null;
        last = null;
    }
    public DoubleLinkedList(Item [] item){
        for(int i = 0; i < item.length; i++)
//            appendhead(item[i]);
              appendtail(item[i]);
    }

    //判空
    public boolean isEmpty(){return first == null;}
    //添加元素,头插法
    public void appendhead(Item item) {
        DoubleNode dnode = new DoubleNode();
        dnode.item = item;
        if (isEmpty()) {
            first = dnode;
            first.next = null;
            first.prev = null;
            last = first;
        } else {
            dnode.next = first;
            first.prev = dnode;

            first = dnode;
        }
    }
    //添加元素,尾插法
    public void appendtail(Item item) {
        DoubleNode dnode = new DoubleNode();
        dnode.item = item;
        if (isEmpty()) {
            first = dnode;
            first.next = null;
            first.prev = null;
            last = first;
        } else {
            last.next = dnode;
            dnode.prev= last;
            last = dnode;
        }
    }
    //查找结点
    public DoubleNode finditem(Item item){
         DoubleNode curr = first;
         while(curr != null){
             if(curr.item == item) return curr;
             curr = curr.next;
         }
         return null;

    }
    //在指定节点前(true)后(false)插入结点
    //在指定结点item1前或后插入item2
    public void InsertNode(Item item1, Item item2,boolean bool){
        DoubleNode dnode = new DoubleNode(item2);

        DoubleNode curr = finditem(item1);
        if(bool == true){
            curr.prev.next = dnode;
            dnode.prev =  curr.prev;
            curr.prev = dnode;
            dnode.next = curr;
        }
        else{
            dnode.next = curr.next;
            curr.next.prev = dnode;
            curr.next = dnode;
            dnode.prev = curr;

        }

    }
    //遍历链表，bool = true 为从正序遍历；否则为逆序遍历；
    public void Print(boolean bool){
        if(bool == true){
            DoubleNode curr =first;
            while(curr != null){
                StdOut.printf("%s--> ",curr.item);
                curr = curr.next;
            }
            StdOut.println();
        }else{
            DoubleNode curr =last;
            while(curr != null){
                StdOut.printf("%s--> ",curr.item);
                curr = curr.prev;
            }
            StdOut.println();
        }


    }
    //删除结点
    public  Item DeleteNode(Item item){
        if(isEmpty())  throw new RuntimeException("The List is Empty!");
        DoubleNode dnode = finditem(item);
        if(dnode == null ) throw new RuntimeException("The itme  is not exsit in the list!");
        if(dnode == last ){
            dnode.prev.next = null;
            last = dnode.prev;

        }else if(dnode == first){
            first = dnode.next;
            dnode.next.prev = null;

        }
        else{
            dnode.prev.next = dnode.next;
            dnode.next.prev = dnode.prev;


        }
        return dnode.item;

    }
    //迭代
    public Iterator<Item> iterator() { return new DoubleLinkedListIterator();}

    private class DoubleLinkedListIterator implements Iterator<Item>
    {
        private DoubleNode current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

//        private DoubleNode current = last;
//
//        public boolean hasNext()  { return current != null;                     }
//        public void remove()      { throw new UnsupportedOperationException();  }
//
//        public Item next()
//        {
//            if (!hasNext()) throw new NoSuchElementException();
//            Item item = current.item;
//            current = current.prev;
//            return item;
//        }

    }


}
