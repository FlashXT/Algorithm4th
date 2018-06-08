package CH1.CH1_5;

public class CallMain {
    public static void main(String [] args){
        String [] str = new String[10];
        str[0] = "src\\CH1\\Data\\tinyUF.txt";
        try{
            UnionFindBase.main(str);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
