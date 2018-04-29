package CH1.CH1_3.ProblemList_Queue;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class List<Item> implements Iterable<Item> {
    public Node first;
    private Node last;
    public class Node{
        Item item;
        Node next;
        public Node(){}
        public Node(Item item){
             this.item = item;
             this.next = null;
        }

    }
    private int N;


    //构造方法
    public List(Item[] a)
    {
        for (Item t : a)
            append(t);
    }

    public List(Iterable<Item> coll)
    {
        for (Item t : coll)
            append(t);
    }

    public List(){first = null; last = null;}
    public boolean isEmpty(){return first == null;}
    public int size(){return N;}

    public Item getFirst(){
        if(isEmpty()) throw new RuntimeException("List is  Empty!");
        return first.item;
    }
    public Item getLast(){
        if(isEmpty()) throw new RuntimeException("List is  Empty!");
        return last.item;
    }
    public Item removeFirst(){
        if(isEmpty()) throw new RuntimeException("List is  Empty!");
        Item item = first.item;
        first = first.next;
        N--;
        if(isEmpty()) last = null;
        return item;
    }
    public Item removeLast(){
        if(isEmpty()) throw new RuntimeException("List is  Empty!");
        if(first == last) return removeFirst();
        Item item = last.item;
        Node prev = null,curr = first;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        N--;
        return item;
    }
    public void Insert(Item key,Item item){
        Node curr = first;
        while(curr.item != key && curr.next != null){

            curr = curr.next;
        }
         Node temp = new Node();
         temp.item = item;
         temp.next=curr.next;
         curr.next=temp;
         N++;
    }

    public void Delete(Item item){

        Node prev = first,curr = first;
        while( curr.next!= null && curr.item != item){
            prev = curr;
            curr = curr.next;
        }

        if(curr.item == item){
            prev.next = curr.next;
            N--;
        }


    }

     //头插法与尾插法
     public void prepend(Item item)
     {
         Node x = new Node();
         x.item = item;
         if (isEmpty()) { first = x;      last = x;  }
         else           { x.next = first; first = x; }
         N++;
     }

    public void append(Item item)
    {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) { first = x;     last = x; }
        else           { last.next = x; last = x; }
        N++;
    }

    // Reverse List 1.3.30
    public Node ReverseList(Node pointer){
        if(pointer == null || pointer.next == null) return pointer;


        Node second = ReverseList(pointer.next);

        pointer.next.next = pointer;
        pointer.next = null;
        return second;

    }


    //迭代
    public Iterator<Item> iterator()
    {
        return new ProblemListIterator();
    }

    private class ProblemListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
