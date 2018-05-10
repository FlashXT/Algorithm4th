package CH1.CH1_4.CH1_4_34_GuessNumberHotOrCold;

import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

public class GuessNumber {
    int start = 1;
    int end = 100;
    int key = 32;
    int count = 0;
    int lastGuess = 0;
    public  String GuessResult(int N){
//        count ++;
//        if(count < 2){
//            if( N == key){lastGuess = N; return "Equal";}
//            else {lastGuess = N;return "Not Equal";}
//        }
//
//        else{
            if( N == key) {lastGuess = N; return "Equal";}
            if(Math.abs(lastGuess - key)< Math.abs(N - key))
            {lastGuess = N;return "Cloder";}
            else {lastGuess = N; return "Hotter";}
//        }



    }
    public static void main(String [] args){

        StdOut.print("Please guess number(0~100):");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        GuessNumber GN = new GuessNumber();
        String flag = GN.GuessResult(num);
        while(!flag.equals("Equal")){
            StdOut.print("Again:");
            num = scan.nextInt();
            flag = GN.GuessResult(num);
            StdOut.println(flag);
        }


    }
}
