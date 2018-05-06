package CH1.CH1_4.CH1_4_21_MihaiPatrascu;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearchWithAddSub {
    public static void main(String [] args){
        int [] data = {1,2,4,7,9,10,12,13,14,17,18,20,21,34,45,56,76,1,44,48,50};
        Arrays.sort(data);

        StdOut.println(BinarySearchAS(data,18));




    }
    public static int BinarySearchAS(int [] data,int key){
        int Fk = 1;
        int Fk_1 = 1;
        int Fk_2 = 0;

        while(Fk < data.length){
            Fk = Fk + Fk_1;
            Fk_1 = Fk_1 + Fk_2;
            Fk_2 = Fk - Fk_1;
        }
        int low = 0;
        while(Fk_2 >= 0){
            int index = low+Fk > data.length - 1 ? data.length-1:low+Fk;
            if(data[index] < key) low = low + Fk_2;
            if(data[index] == key) return index;
            Fk=Fk_1;
            Fk_1=Fk_2;
            Fk_2 = Fk-Fk_1;
        }
        return -1;
    }
    public static int Fibnacci(int N){
        if( N == 1 || N== 0) return 1;
        return Fibnacci(N-1)+Fibnacci(N-2);

    }
}
