package CH1.CH1_4.TheMinElement_of_local;

import edu.princeton.cs.algs4.StdOut;

public class TheMinElementOfLocalinMatrixBase {
    public static void main(String[] args) {
        int[][] data = Matrix();
        int []index =  MatrixMinLocal(data);
        StdOut.println(index[0]+","+index[1]);

    }

    //Brute Force:O(N^2)
    public static int[] MatrixMinLocal(int[][] a) {

        int [][] b = new int[a.length+2][a.length+2];
        int[] index = new int[2];
        //对数组行列进行扩充，便于处理
        for(int i = 0;i <b.length;i++)
            for(int j = 0;j < b[i].length;j++){
             if(i==0 || i ==a.length+1 || j==0 || j == a.length+1)
                 b[i][j]= Integer.MAX_VALUE;
             else
                 b[i][j]=a[i-1][j-1];
        }

//        for(int i = 0;i <b.length;i++){
//            for(int j = 0;j < b[i].length;j++)
//                StdOut.printf("%3d",b[i][j]);
//            StdOut.println();
//        }

        for (int i = 1; i < b.length-1; i++){
            for (int j = 1; j < b[i].length-1; j++) {
                 if ( a[i][j] < a[i][j - 1] && a[i][j] < a[i][j + 1]&&
                      a[i][j] < a[i - 1][j] && a[i][j] < a[i + 1][j]  )
                        {   index[0] = i;index[1] = j;return index; }
            }

        }
        return index;
    }

    public static int[][]Matrix(){
        int[][] data =  {{9,3,5,2,4,9,8},
                         {7,2,5,1,4,0,3},
                         {9,8,9,3,2,4,8},
                         {7,6,3,1,3,2,3},
                         {9,0,6,0,4,6,4},
                         {8,9,8,0,5,3,0},
                         {2,1,2,1,1,1,1}};
        return data;
    }
}
