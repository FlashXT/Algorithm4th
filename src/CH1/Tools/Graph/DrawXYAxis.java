package CH1.Tools.Graph;

import edu.princeton.cs.algs4.StdDraw;
import java.awt.*;

import static edu.princeton.cs.algs4.StdDraw.getPenRadius;

public class DrawXYAxis {

    public int X;
    public int Y;
    public DrawXYAxis(int x, int y){
        this.X = x;
        this.Y = y;

    }
    public void XYAxis(int x ,int y){
        StdDraw.setXscale(0,x);
        StdDraw.setYscale(0,y);
        StdDraw.setPenRadius(0.003);
        //Y轴
        StdDraw.line(0.1*x,0.1*y,0.1*x,y-0.1*y);
        //X轴
//        StdDraw.line(0.1*x,0.1*y,x-0.1*x,0.1*y);
        StdDraw.setPenColor(Color.red);
        StdDraw.setPenRadius(0.003);
        //X轴刻度
        for(double i = 0.1*x ; i < x-0.1*x; i+=0.1*x){
            StdDraw.point(i,0.1*y);
            StdDraw.text(i,0.05*y,String.valueOf(i- 0.1*x));
        }
        //Y轴刻度
        for(double j = 0.1*y ; j < y-0.1*y; j+=0.1*y){
            StdDraw.point(0.1*x,j);
            StdDraw.text(0.07*x,j,String.valueOf(j - 0.1*y));
        }
        StdDraw.setPenColor(Color.BLACK);

    }
    public boolean drawPoint(double x, double y){
        if(x >=0 && x <= this.X && y >=0 && y <= this.Y){
            XYAxis(this.X ,this.Y);
            Color Pencolor = StdDraw.getPenColor();
            double PenRadius = StdDraw.getPenRadius();
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.setPenRadius(0.003);
            StdDraw.point(this.X*0.1+x,this.Y*0.1+y);
            StdDraw.setPenColor(Pencolor);
            StdDraw.setPenRadius(PenRadius);
            return true;
        }
        else {
            return false;
        }

    }
    public boolean drawLine(double x1, double y1,double x2, double y2){
        if(x1>=0 && x1 <= this.X && y1 >=0 && y1 <= this.Y &&
                x2>=0 && x2 <= this.X && y2 >=0 && y2 <= this.Y ){
            XYAxis(this.X ,this.Y);
            StdDraw.line(this.X*0.1+x1,this.Y*0.1+y1,this.X*0.1+x2,this.Y*0.1+y2);
            return true;
        }
        else {
            return false;
        }

    }
    public static void main(String [] args){
        DrawXYAxis xyAxis = new DrawXYAxis(20,50);
        StdDraw.setPenRadius(0.1);
        xyAxis.drawPoint(10,25);
    }
}
