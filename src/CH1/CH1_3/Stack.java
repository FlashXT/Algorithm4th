/*Algorithm4th,CH1.3,利用ArrayList实现；
 * Author:turboMan
 * Date:2018.4.4;
 * */
package CH1.CH1_3;


import java.util.ArrayList;

public class Stack <T> {
    private ArrayList <T> list;

    public Stack(){
        list = new ArrayList<T>();
    }
    public Stack(int N){

        list = new ArrayList<T>(N);
    }

    public int getSize() {
        return list.size();
    }
   public boolean push(T item){

        return list.add(item);
   }
   public T pop(){

        T item= list.get(getSize()-1);
        list.remove(getSize()-1);
        return item;
   }

    public boolean isEmpty(){

        return list.isEmpty();
    }

}
