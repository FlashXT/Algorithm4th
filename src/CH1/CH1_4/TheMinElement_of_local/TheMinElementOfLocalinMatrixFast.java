package CH1.CH1_4.TheMinElement_of_local;

import edu.princeton.cs.algs4.StdOut;


/********************************************************************************
 * 算法思路：在第N/2行找到最小条目，比如说a[N/2][j]。 检查它的两个垂直邻居a[N/2-1][j]
 *         和a[N/2+1][j]。 在较小的邻居的一半中。在那一半中，找到第a[N/2]列中的最小条目。
 *
 ********************************************************************************/

public class TheMinElementOfLocalinMatrixFast {
    public static void main(String[] args) {
        int[][] data = Matrix();
        int []index =  MatrixMinLocal(data);
        StdOut.println(index[0]+","+index[1]);

    }

    public static int[] MatrixMinLocal(int[][] a) {

        int[] index = new int[2];
        MinLocalMatrixRecursion(a,1,a.length-2,index);
        return index;

    }

    //对数组行列进行扩充，便于处理
    public static int[][] Matrix(){

        int[][] a =  {      {9,3,5,2,4,9,8},
                            {7,3,5,4,3,4,4},
                            {9,8,9,3,3,4,8},
                            {7,6,3,1,3,2,3},
                            {9,6,6,3,4,6,4},
                            {8,9,8,0,5,3,0},
                            {2,1,2,1,1,1,1}     };
        int [][] b = new int[a.length+2][a.length+2];

        for(int i = 0;i <b.length;i++)
            for(int j = 0;j < b[i].length;j++){
                if(i==0 || i ==a.length+1 || j==0 || j == a.length+1)
                    b[i][j]= Integer.MAX_VALUE;
                else
                    b[i][j]=a[i-1][j-1];
            }
        return b;
    }

    //时间复杂度为O(N),全局最小
    public static int MinLocalRecursion(int [] data,int start,int end){
            int index = -1;
            int temp = Integer.MAX_VALUE;
            for(int i =start; i <= end; i++)
            {
                if(data[i-1] > data[i] && data[i] < data[i+1]){
                    if(data[i] < temp){temp = data[i];index = i;}
                }
            }
            return index;
        }


    //递归方法(如果一列中有重复值，不一定能找到局部最小值，待解决)
    public static int[] MinLocalMatrixRecursion(int [][] data,int start,int end,int []index){
        if(start > end) {index[0] = -1;index[1] = -1;return index;}
        int mid = (start + end)/2;

        int columLocalmin = MinLocalRecursion(data[mid],1,data[mid].length-2);
        if( data[mid-1][columLocalmin] > data[mid][columLocalmin]
                && data[mid+1][columLocalmin] > data[mid][columLocalmin]){
            index[0] = mid-1;index[1] = columLocalmin-1;return index;
        }
        if(data[mid-1][columLocalmin] < data[mid+1][columLocalmin])
               return MinLocalMatrixRecursion(data,0,mid-1,index);
        else   return MinLocalMatrixRecursion(data,mid+1,end,index);

    }

}
