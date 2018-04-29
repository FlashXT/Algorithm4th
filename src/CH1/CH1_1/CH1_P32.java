/* Algorithm4th，
 * Author:FlashXT
 * Date:2018.4.1,Sunday
 * */
package CH1.CH1_1;

import edu.princeton.cs.algs4.StdDraw;

public class CH1_P32 {
    public static void main(String [] args){
       double [] array={1,3,23,43,67,43,43,43,12,3,23,45,67,34,12,56,78,45,34,78,89,89,39,100};
       Drawhistgram(array,10,0,100);
    }
    /*接受一个整数N和两个double值l和r.将（l,r）分为N段并使用
    *StdDraw画出输入流中的值落入每段的数量的直方图。*/
    public static void Drawhistgram(double [] array,int N,double l,double r){
         int []count= new int[N];
         double temp=(r-l)/N;
         for(int i=0;i<array.length;i++){
                count[(int)Math.ceil((array[i]-l)/temp)-1]++;
         }

         StdDraw.setCanvasSize(512, 512);
         StdDraw.setXscale(0, 10);
         StdDraw.setYscale(0, 10);
         StdDraw.setPenRadius(0.01);

         StdDraw.line(0,0,10,0);
         StdDraw.line(0,0,0,10);
         StdDraw.setPenRadius(0.02);
         for (int i =0; i < 10; i++)
         {
            StdDraw.point(0,i);
            StdDraw.point(i,0);
         }
         StdDraw.setPenColor(255,32,53);
         for(int i=0;i<count.length;i++){
             //System.out.println(count[i]);
                 //当前要画的小矩形的中心坐标
                 double x=i+0.5;
                 double y=count[i]/2.0;
                 //rw为要绘制的小矩形的宽度的一半
                 double rw=0.3;
                 //rh为要绘制的小矩形的高度的一半
                 double rh=count[i]/2.0;
                 //x,y代表是矩形中心的坐标。 rw, rh分别代表矩形宽的一半，和高的一半。
                 StdDraw.filledRectangle(x,y,rw,rh);
         }

    }
}
