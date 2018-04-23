package CH1.CH1_4;

public class testClass {
    public static void main(String [] args){
        String [][] str = {{"src\\CH1\\CH1_4\\1Kints.txt"},
                           {"src\\CH1\\CH1_4\\2Kints.txt"},
                           {"src\\CH1\\CH1_4\\4Kints.txt"},
                           {"src\\CH1\\CH1_4\\8Kints.txt"}
                          };
        ThreeSum.main(str[0]);
        ThreeSum.main(str[1]);
        ThreeSum.main(str[2]);
        ThreeSum.main(str[3]);

    }
}
