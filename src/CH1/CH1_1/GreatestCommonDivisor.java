package CH1.CH1_1;

public class GreatestCommonDivisor {
    public static void main(String [] args){

        System.out.println(GCD(1111111,1234567));

    }
    public static int GCD(int num1,int num2){
        System.out.println(num1+"  "+num2);
        if(num1%num2==0) return num2;
        return GCD(num2,num1%num2);

    }
}
