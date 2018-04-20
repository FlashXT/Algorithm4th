/*Algorithm4th,CH1.3_P34,实现RandomBag
 *Author：FlashXT;
 * Date:2018.4.19,Thursday;
 * */
package CH1.CH1_3.Bag;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Random;

public class RandomBag<Item> implements Iterable<Item> {

    Item [] rbag = (Item []) new Object[10];
    int []flag = new int[rbag.length];

    private int N = 0;

    public RandomBag(){    }
    public RandomBag(Item [] item){
        for(int i = 0; i < flag.length;i++)
            flag[i] = 0;
        for(int i = 0; i < item.length;i++)
            add(item[i]);
    }

    //背包是否为空
    public boolean isEmpty(){
       return N == 0;
    }
    //背包中的元素数量
    public int size(){
        return N;
    }
    //添加一个元素
    public void add(Item item){
           Random rand = new Random();
           int temp = rand.nextInt(rbag.length);
           while(flag[temp] == 0){
               temp = rand.nextInt(rbag.length);
//               StdOut.println(temp);
           }

           rbag[temp] = item;
           flag[temp] = 1;
           N++;

    }
    //删除一个元素
    public void Delete(Item item){

        for(int i = 0 ; i < rbag.length; i++)
        {
            if(rbag[i] == item) {
                rbag[i] = null;
                flag[i]=0;
            }
        }
    }
    //判断一个元素是否在bag中
    public boolean inBag(Item item){
        for(int i = 0 ; i < rbag.length; i++)
        {
            if(rbag[i] == item) return true;
        }
        return false;
    }

    //随机迭代
    public Iterator<Item> iterator(){return new RandomBagIterator();}
    private class RandomBagIterator implements Iterator<Item>{

        Random rand = new Random();
        private  int temp = rand.nextInt(rbag.length);

        public boolean hasNext(){
            int num = 0;
            for(int i = 0; i < flag.length; i++)
            {
                if(flag[i] == 2) num++;
            }
             return num != N;
        }
        public Item next(){
            Random rand = new Random();
            temp = rand.nextInt(rbag.length);
            int num = 0;
            while(flag[temp] != 1){
                temp = rand.nextInt(rbag.length);

            }
            flag[temp] = 2;
            return  rbag[temp];

        }
        public void remove(){}
    }
}
