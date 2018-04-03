
package CH1.CH1_1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class CH1_P31
{
    public static void drawRandConn(int N, double p)
    {
        //①设置画布大小
        StdDraw.setCanvasSize(1024, 1024);
        //②设置x,y的范围，也可以用setXscale,setYscale分别设置
        StdDraw.setScale(-6, 6);
        //③设置画笔粗细
        StdDraw.setPenRadius(0.005);
        //④绘制X轴，Y轴
        StdDraw.line(0,-6,0,6);
        StdDraw.line(-6,0,6,0);
        //⑤设置画笔，绘制坐标轴刻度
        StdDraw.setPenRadius(0.01);
        for (int i = -6; i < 7; i++)
        {
            StdDraw.point(0,i);
            StdDraw.point(i,0);
        }
        //绘制圆形
        StdDraw.setPenRadius(.005);
        StdDraw.circle(0,0,3);
        //设置
        StdDraw.setPenRadius(.03);
        double[][] d = new double[N][2];
        for (int i = 0; i < N; i++)
        {
            d[i][0] = 3*Math.cos(2 * Math.PI * i / N);
            d[i][1] = 3*Math.sin(2 * Math.PI * i / N);
            StdDraw.point(d[i][0], d[i][1]);
        }

        StdDraw.setPenRadius();

        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                if (StdRandom.bernoulli(p))
                    StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
    }

    public static void main(String[] args)
    {
        int N = 10;//Integer.parseInt(args[0]);
        double p = 0.25;//Double.parseDouble(args[1]);
        p = Math.max(0, Math.min(1, p));

        drawRandConn(N, p);
    }
}
