package CH1.CH1_4.TheMinElement_of_local;

import edu.princeton.cs.algs4.StdOut;


/********************************************************************************
 * 算法思路：在第N/2行找到最小条目，比如说a[N/2][j]。 检查它的两个垂直邻居a[N/2-1][j]
 *         和a[N/2+1][j]。 在较小的邻居的一半中。在那一半中，找到第a[N/2]列中的最小条目。
 *
 ********************************************************************************/

public class TheMinElementOfLocalinMatrixFast {
    public static void main(String[] args) {
        int[][] data =  {   {9,3,5,2,4,9,8},
                            {7,2,5,1,4,0,3},
                            {9,8,9,3,2,4,8},
                            {7,6,3,1,3,2,3},
                            {9,0,6,0,4,6,4},
                            {8,9,8,0,5,3,0},
                            {2,1,2,1,1,1,1}     };
        int []index =  MatrixMinLocal(data);
        StdOut.println(index[0]+","+index[1]);

    }

    public static int[] MatrixMinLocal(int[][] a) {

        int[] index = new int[2];
        MinLocalMatrixRecursion(a,0,a.length-1,index);
        return index;

    }


    //递归方法(在边界处存在溢出现象，未解决)
    public static int[] MinLocalMatrixRecursion(int [][] data,int start,int end,int []index){
        int mid = (start + end)/2;
        int columLocalmin = MinLocalRecursion(data[mid],0,data[mid].length-1);
        if( data[mid-1][columLocalmin] > data[mid][columLocalmin]
                && data[mid+1][columLocalmin] > data[mid][columLocalmin]){
            index[0] = mid;index[1] = columLocalmin;return index;
        }
        if(data[mid-1][columLocalmin] < data[mid+1][columLocalmin])
               return MinLocalMatrixRecursion(data,start,mid-1,index);
        else   return MinLocalMatrixRecursion(data,mid+1,end,index);

    }

    //递归寻找行的局部最小值
    public static int MinLocalRecursion(int [] data,int start,int end){
        int mid = ( start + end )/2;
        if(data[mid-1] > data[mid] && data[mid] < data[mid +1])  return mid;
        if(data[mid-1] > data[mid+1]) return MinLocalRecursion(data,mid+1,end);
        else return MinLocalRecursion(data,start,mid-1);
    }
}
