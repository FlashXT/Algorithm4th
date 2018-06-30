package CH1.Tools.IO;

import java.io.FileInputStream;

public class TestFileInputStream {
    public static void main(String [] args){
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(args[0]);
            int size = fis.available();
            byte [] array = new byte[size] ;
            fis.read(array);

            String result = new String(array);
            System.out.println(result.charAt(2));
            for(int i : array)
              System.out.println(array[i]);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
