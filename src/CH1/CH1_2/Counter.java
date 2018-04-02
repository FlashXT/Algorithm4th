package CH1.CH1_2;

public class Counter {
    public String id;
    public int count=0;
    public Counter(){}
    public Counter(String id){
        this.id=id;
    }
    public void increment(){
        count++;
    }
    public int tally(){
         return count;
    }
    public String toString(){
        return super.toString();
    }
}
