package CH1.CH1_4.DoublingRatioExperiments;


import edu.princeton.cs.algs4.StdDraw;

public class DrawGraph {
    public static void main(String [] args){
        DrawXYBase();
    }
    public static void DrawXYBase(){
        StdDraw.setXscale(-100,20000);
        StdDraw.setYscale(-100,2000);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        StdDraw.line(0,0,0,2000);
        StdDraw.line(0,0,18000,0);
//        StdDraw.setPenColor(StdDraw.RED);
//        StdDraw.setPenRadius(0.010);
//        for(int i = 0 ; i < 18000; i+=100)
//        {
//            StdDraw.point(0,i);
//            StdDraw.point(i,0);
//        }

    }
    public static void DrawPoint(double x, double y){

//        StdDraw.setPenRadius(0.02);
//        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(x,y);
    }
    public static void DrawLine(double x, double y,double x2,double y2){

        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(x,y,x2,y2);
    }
}
