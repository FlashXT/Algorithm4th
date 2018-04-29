package CH1.Tools;

import CH1.CH1_4.DoublingRatioExperiments.DoublingTest;

public class testClass {
    public static void main(String [] args){
        String [][] str = {{"src\\CH1\\CH1_4\\1Kints.txt"},
                           {"src\\CH1\\CH1_4\\2Kints.txt"},
                           {"src\\CH1\\CH1_4\\4Kints.txt"},
                           {"src\\CH1\\CH1_4\\8Kints.txt"},
                           {"100000"}};

//        ThreeSum.main(str[0]);
//        ThreeSum.main(str[1]);
//        ThreeSum.main(str[2]);
//        ThreeSum.main(str[3]);
        DoublingTest.main(str[4]);

    }
}
