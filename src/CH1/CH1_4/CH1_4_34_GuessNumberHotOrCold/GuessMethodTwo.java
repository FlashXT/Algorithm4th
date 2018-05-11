package CH1.CH1_4.CH1_4_34_GuessNumberHotOrCold;

/*************************************************************************************************
 * 分析：Suppose you know that your secret integer is in [a,b], and that your last guess is c.
 *      You want to divide your interval by two, and to know whether your secret integer lies
 *      in between [a,m] or [m,b], with m=(a+b)/2.
 *
 *      The trick is to guess d, such that (c+d)/2 = (a+b)/2.
 *
 *      Without loss of generality, we can suppose that d is bigger than c. Then, if d is hotter
 *      than c, your secret integer will be bigger than (c+d)/2 = (a+b)/2 = m, and so your secret
 *      integer will lie in [m,b]. If d is cooler than c, your secret integer will belong to [a,m].
 *
 *      You need to be able to guess between -N and 2N because you can't guarantee that c and d as
 *      defined above will always be [a,b]. Your two first guess can be 1 and N.
 *      So, your are dividing your interval be two at each guess, so the complexity is log(N)+O(1).
 *
 *      A short example to illustrate this (results chosen randomly):
 *
 *             Guess    Result    Interval of the secret number
 *              1       ***              [1   , N    ]               // d    =  a   +  b  - c
 *              N       cooler           [1   , N/2  ]               // N    =  1   +  N  - 1
 *             -N/2     cooler           [N/4 , N/2  ]               //-N/2  =  1   + N/2 - N
 *             5N/4     hotter           [3N/8, N/2  ]               // 5N/4 = N/4  + N/2 + N/2
 *             -3N/8    hotter           [3N/8, 7N/16]               //-3N/8 = 3N/8 + N/2 - 5N/4
 *               .         .                    .                              .
 *               .         .                    .                              .
 *               .         .                    .                              .
 *
 *   Q:Why the guess range in [-N,2N]?
 *
 *   A:We still need to prove that our guess will always fall in bewteen [-N,2N];
 *   By recurrence, suppose that c (our previous guess) is in [a-(a+b), b+(a+b)] = [-b,a+2b]
 *   Then d = a+b-c <= a+b-(-b) <= a+2b and d = a+b-c >= a+b-(a+2b) >= -b
 *   Initial case: a=1, b=N, c=1, c is indeed in [-b,a+2*b]
 *
 *   QED(证明完毕)
 *
 * 理解：此方法的核心就是，假设范围为[a,b],lastguess = c, 要达到lgN的猜测次数，需要使用二分查找的思想，那么nowguess
 *      怎么确定？利用 a+b/2 = (c+d)/2;那么 nowguess = d;例如：
 *      第一次guessnum = 1;第二次guessnum =N,Colder(假设);查找范围：[1,N] ---> [1,N/2];更新lastguess = N;
 *      第三次:
 *          分析：猜的数字应该使[1,N/2]再缩小为[1,N/4]或[N/4,N/2];那么(lastguess + nowguess)/2 = (1+N/2)/2;
 *          得到nowguess = -N/2;所以
 *         第三次guessnum = -N/2,Colder(假设);说明 -N/2距key比N更远；此时，查找范围：[1,N/2] ---> [N/4,N/2];
 *      依此类推。。。
 *      该程序再最坏情况下的猜测次数为：log2(N)+2;
 *
 * URL: https://stackoverflow.com/questions/25558951/hot-and-cold-binary-search-game
 * Author:FlashXT;Date:2018.5.11,Friday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 **************************************************************************************************/

import edu.princeton.cs.algs4.StdOut;

public class GuessMethodTwo {

    public static void main(String [] args){
        GuessGame GG = new GuessGame();
        int low = GG.getStart();
        int high= GG.getEnd();
        int lastGuess = 0;
        String guessResult = " ";
        StdOut.printf("%8s\t\t\t%8s\t\t%8s\t\t%8s(Key:%3d)\n","GuessNumber","GuessResult","   Space    --->   Space","lastGuess",GG.getKey());
        StdOut.println("======================================================================================");

        while(high - low >1){
            lastGuess = GG.getLastGuess();
            int guessnum = low+high - GG.getLastGuess();
            guessResult = GG.GuessResult(guessnum);
            StdOut.printf("%4d\t\t\t\t%-8s\t\t[%3d,%3d]",guessnum,guessResult,low,high);
            if(guessResult.equals("Equal")){
                StdOut.println("Key = "+guessnum+",GuessTimes = "+GG.getCount());break;
            }

            //guessnum 在[low,high]区间的左边的情况
            if(Math.abs(guessnum - low) < Math.abs(guessnum - high)){
                if(guessResult.equals("Hotter"))
                    high = (low+high)/2;
                if(guessResult.equals("Colder"))
                    low = (low+high)/2;
            }
            //guessnum 在[low,high]区间的右边的情况
            else{
                if(guessResult.equals("Hotter"))
                    low = (low+high)/2;
                if(guessResult.equals("Colder"))
                    high = (low+high)/2;
            }


            StdOut.printf("\t\t[%3d,%3d]\t\t\t%4d\t\t\t\n",low,high,lastGuess);

        }
        if(!guessResult.equals("Equal"))
            for(int i = low; i <= high;i++){
                guessResult = GG.GuessResult(i);
                if(guessResult.equals("Equal")){
                    StdOut.println("Key = "+i+",GuessTimes = "+GG.getCount());break;
                }
            }

    }
}
