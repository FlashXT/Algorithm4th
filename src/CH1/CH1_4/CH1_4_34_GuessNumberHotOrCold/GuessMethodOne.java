package CH1.CH1_4.CH1_4_34_GuessNumberHotOrCold;

/***********************************************************************************
 * 分析：此种解法类似于二分法，每次循环需要猜两次，分别为上限和下限，如果边界值猜中的话直接返回，否则：
 *      如果右边界比较接近key，那么左边界向右边界靠，lo=mid；否则，右边界向左边界靠，high = mid;
 *      由于每次循环猜两次，所以比较次数为 ~2lgN;
 ***********************************************************************************/

import edu.princeton.cs.algs4.StdOut;

public class GuessMethodOne {

    public static void main(String [] args){
        GuessGame GG = new GuessGame();
        int low = GG.getStart();
        int high= GG.getEnd();
        String guessResult;
        while(low < high){

            guessResult = GG.GuessResult(low);
            if(guessResult.equals("Equal")){
                StdOut.println("Key = "+low+",GuessTimes = "+GG.getCount());break;
            }
            guessResult = GG.GuessResult(high);
            if(guessResult.equals("Equal")){
                StdOut.println("Key = "+high+",GuessTimes = "+GG.getCount());break;
            }
            else{
                if(guessResult.equals("Hotter"))
                    low = (low+high)/2;
                else
                    high = (low+high)/2;
            }


        }


    }
}
