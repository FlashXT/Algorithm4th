package CH1.CH1_2;

public class Date {
    private final int value;
    public Date(int m,int d,int y){
       //日期范围为1~31，占用5位，所以月份左移5位，即乘以2^5;
       //月份范围为1~12，占用4位，所以年份一共要左移9位，即乘以2^9;
       value=y*512+m*32+d;
    }
    public int month(){
        return (value/32)%16;
    }
    public int day(){
        return value%32;
    }
    public int year(){
        return value/512;
    }
    public String toString(){
        return month()+"/"+day()+"/"+year();
    }
    public static void main(String [] args){

    }
}
