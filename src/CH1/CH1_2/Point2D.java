/*Algorithm4th,CH1.2.1，输入N个点，找出这N个点中距离最近的两个点，将它们连起来
 * Author:FlashXT
 * Date:2018.4.3,Monday*/
package CH1.CH1_2;


import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;


import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Point2D {
    public static double [][]Points;
    public static void main(String [] args){
        StdOut.printf("请输入要生成的点数：");
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        StdDraw.setScale(-N/10,N+N/10);
        PointNum(N);
        DrawLine(MinDistance(Points));
    }
    public static void PointNum(int N){
        Points = new double [N][2];
        Random rand = new Random(N);
        StdDraw.setPenRadius(0.02);
        for(int i=0;i < N; i++){
          Points[i][0]= rand.nextInt(N);
          Points[i][1]= rand.nextInt(N);
          StdDraw.point(Points[i][0],Points[i][1]);
        }
//        for(int j=0; j < Points.length;j++)
//            StdOut.println(Points[j][0]+","+Points[j][1]);
    }
    public static int[]  MinDistance(double [][]P){
        double [][]dis = new double[P.length][P.length];
        //初始化距离为负值
        for(int i=0;i < P.length;i++)
            for (int j = 0; j < P.length; j++)
                dis[i][j] = -1;
        //计算并保存距离
        for(int i=0;i < P.length-1;i++) {
            for (int j = i + 1; j < P.length; j++) {
                dis[i][j] = (P[i][0] - P[j][0]) * (P[i][0] - P[j][0]) + (P[i][1] - P[j][1]) * (P[i][1] - P[j][1]);
            }

        }
        double temp= Double.MAX_VALUE;
        int [] p=new int [2];
        for(int i=0;i < P.length;i++) {
            for (int j = i+1; j < P.length; j++) {
               if(dis[i][j]>0) {
                   if(dis[i][j]< temp) {
                       temp = dis[i][j];
                       p[0]=i;
                       p[1]=j;
                   }
               }
            }

        }
        return  p;

    }
    public static void DrawLine(int[] p){
        StdDraw.setPenColor(Color.RED);
        StdDraw.setPenRadius(0.005);

        StdDraw.line(Points[p[0]][0],Points[p[0]][1],Points[p[1]][0],Points[p[1]][1]);
    }
}
