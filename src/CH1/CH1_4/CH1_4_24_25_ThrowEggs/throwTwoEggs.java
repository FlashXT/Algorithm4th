/*****************************************************************************************
 * 题目：扔2个鸡蛋。假设你前面有一栋N层的大楼和2个鸡蛋，假设将鸡蛋从F层或者更高的地方扔下才会摔碎，否
 *      则不会。首先，设计一种策略来确定F的值，最多扔2√(N)次的鸡蛋即可判断出F值，然后想办法把这个成
 *      本降低到~C√(F)次。这种查找命中(鸡蛋未碎)比未命中（鸡蛋摔碎）的成本小的多。
 * 算法分析：第一问：第一个蛋按照 √(N), 2√(N), 3√(N), 4√(N),..., √(N) * √(N) 顺序查找直至碎掉。
 *         这里扔了 k 次，k <= √(N)。然后在 (k-1)√(N) ~ k√(N)范围内顺序查找直至碎掉，F 值就找到
 *         了。这里最多扔 √(N) 次。
 *         第二问：需要数学推导；
 *            假设题目所要求的策略存在，该策略可以保证在最坏情况下至多需要扔x次鸡蛋就可以找出临界楼层；
 *            此时可以将问题转化为：如果只允许扔x次鸡蛋能确定的最高的楼层是多少。
 *            现在思考， 第一次鸡蛋应该从哪个楼层扔下? 因为此时我们有两个鸡蛋，为了在有限次数内检查尽
 *            可能高的楼层。第一次扔的时候，我们会希望能尽可能高一些 如果鸡蛋没碎，我们就能排除掉越多
 *            的楼层。但是很显然，不能过高，因为万一鸡蛋碎了，第二个鸡蛋就只能从第一层开始尝试起。那么
 *            第一次扔的楼层最高可以选几呢？是x, 因为我们总要考虑最坏情况， 当我们从x层扔下的时候，最
 *            坏的情况有可能是临界层为x-1, 此时就需要尝试x次，才能找到这个临界层。如果第一次尝试的楼层
 *            比x大， 显然会导致最大尝试次数超过x , 不符合我们的假设。
 *            回到我们的问题， 现在知道了在最大尝试次数为x次时，最优策略第一次必然只能从x层扔下的推论后，
 *            我们最大能检查的楼层是多少。由于第一次从x层扔下时，我们已经用掉了一次尝试机会，此时只能再
 *            尝试x-1次。这样我们可以第二次尝试的楼层数可以向上增加x-1层，即为 x + (x-1). 如果再高，
 *            例如第二次我们从2x层扔下，我们在最坏情况下（临界楼层为2x-1），需要尝试的次数会变成x+1,不
 *            符合我们的假设。这样依次类推，第三次向上的增量就只能为 x-3,第四次向上的增量就只能为 x-4,
 *            ……..,最后一次向上的增量为1。此时我们可以得出，如果只能尝试x次，我们能检测的最高楼层为
 *            x+(x−1)+(x−2)+(x−3)....+1=(x∗(x+1))/2。
 *
 * Author:FlashXT;Date:2018.5.8,Tuesday;
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *******************************************************************************************/

package CH1.CH1_4.CH1_4_24_25_ThrowEggs;

import edu.princeton.cs.algs4.StdOut;

public class throwTwoEggs {
    public static void main(String [] args){
        TwoEggsCsqurtF(20);
    }

    public static int TwoEggs(int N){
        int count = 0;
        int k =(int)Math.sqrt(N);
        int i = 1;
        while(!ThrowEgg(i*k))
        {    i++;   }
        count ++;
        int start = (i-1)*k;
        while(!ThrowEgg(start)){
                   start++;
        }
        count++;
        StdOut.println(start +","+count);
        return start;
    }


    public static int TwoEggsCsqurtF(int N){
        int count = 0;
        int x = 1;
        while(!ThrowEgg(x*(x+1)/2) ) x++;

        count ++;
        int start = (x-1)*x/2;

        while(!ThrowEgg(start)){
            start++;
        }
        count++;
        StdOut.println(start +","+count);
        return start;

    }
    public static boolean ThrowEgg(int floor){
        int F = 15;
        return floor >= F;
    }
}
