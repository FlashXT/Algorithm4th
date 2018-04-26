package CH1.CH1_4.DoublingRatioExperiments;


import edu.princeton.cs.algs4.StdDraw;

public class DrawGraph {
    int x0,y0,x1,y1;
    public DrawGraph(){
        this.x0 = 0;
        this.y0 = 0;
        this.x1 = 1000;
        this.y1 = 1000;
    }
    public DrawGraph(int x0,int y0,int x1,int y1){
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }
    public static void main(String [] args){
        DrawGraph dg = new DrawGraph(0,0,2000,120);
        dg.DrawXYBase();
    }
    public  void DrawXYBase(){
        StdDraw.setXscale(x0,x1);
        StdDraw.setYscale(y0,y1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.005);
        //x轴
        StdDraw.line(x0+(x1-x0)/10,y0+(y1-y0)/10,x1-(x1-x0)/20,y0+(y1-y0)/10);
        //y轴
        StdDraw.line(x0+(x1-x0)/10,y0+(y1-y0)/10,x0+(x1-x0)/10,y1-(y1-y0)/40);


        StdDraw.setPenRadius(0.010);
        StdDraw.setPenColor(StdDraw.BLUE);
        //x轴刻度
        for(int i = x0 ; i +(x1-x0)/10<= x1-(x1-x0)/10; i+=100)
        {
            StdDraw.point(x0+(x1-x0)/10+i,y0+(y1-y0)/10);
            StdDraw.text(x0+(x1-x0)/10+i,y0+(y1-y0)/20,i/100+"k");

        }
        //y轴刻度
        for(int i = y0 ; i + (y1-y0)/20 <= y1-(y1-y0)/10; i+=5)
        {
            StdDraw.point(x0+(x1-x0)/10,y0+(y1-y0)/10+i);
            StdDraw.text(x0+(x1-x0)/20,y0+(y1-y0)/10+i,i+"s");

        }
    }

    public void DrawPoint(double x, double y){

        StdDraw.point(x0+(x1-x0)/10+x,y0+(y1-y0)/10+y);
    }
    public  void DrawLine(double x, double y,double x2,double y2){

        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.line(x0+(x1-x0)/10+x,y0+(y1-y0)/10+y,x0+(x1-x0)/10+x2,y0+(y1-y0)/10+y2);
    }
}
