package CH1.CH1_4.CH1_4_34_GuessNumberHotOrCold;

/**********************************************************************************
 * 题目：Hot or cold. Your goal is the guess a secret integer between 1 and N.
 *      You repeatedly guess integers between 1 and N. After each guess you learn
 *      if it equals the secret integer (and the game stops); otherwise (starting
 *      with the second guess), you learn if the guess is hotter (closer to) or
 *      colder (farther from) the secret number than your previous guess. Design
 *      an algorithm that finds the secret number in ~2lgN guesses. Then, design
 *      an algorithm that finds the secret number in ~ 1 lg N guesses.
 *
 *Hint: use binary search for the first part.
 *      For the second part, first design an algorithm that solves the problem in
 *      ~1lgN guesses assuming you are permitted to guess integers in the range -N
 *      to 2N.
 *
 * Author:FlashXT;Date:2018.5.10,Thursday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *
 *********************************************************************************/

import java.util.Random;

public class GuessGame {

    private  int start;
    private  int end;
    private  int key;
    private  int count;
    private  int lastGuess;


    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getKey() {
        return key;
    }

    public int getCount() {
        return count;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    public  GuessGame(){
        start = 1;
        end = new Random().nextInt(1000)+1;
        key = new Random().nextInt(end)+1;
        count = 0;
        lastGuess = start;
    }

    public  String GuessResult(int N){
        count ++;
//        if(count < 2){
//            if( N == key){lastGuess = N; return "Equal";}
//            else {lastGuess = N;return "Not Equal";}
//        }
//
//        else{
            if( N == key) {lastGuess = N; return "Equal";}
            if(Math.abs(lastGuess - key)< Math.abs(N - key))
            {lastGuess = N;return "Colder";}
            else {lastGuess = N; return "Hotter";}
//        }

    }

}
