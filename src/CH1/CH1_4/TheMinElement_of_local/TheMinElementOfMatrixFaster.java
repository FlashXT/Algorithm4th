package CH1.CH1_4.TheMinElement_of_local;

import edu.princeton.cs.algs4.StdOut;


/********************************************************************************
 * 算法思路：在第N/2行找到最小条目，比如说a[N/2][j]。 检查它的两个垂直邻居a[N/2-1][j]
 *         和a[N/2+1][j]。 在较小的邻居的一半中。在那一半中，找到第a[N/2]列中的最小条目。
 *
 ********************************************************************************/

public class TheMinElementOfMatrixFaster {
    public static void main(String[] args) {
        int[][] data = Matrix();
        int []index =  MatrixMinLocal(data);
        StdOut.println(index[0]+","+index[1]);

    }

    public static int[] MatrixMinLocal(int[][] a) {

        int[] index = new int[2];
        MinLocalMatrixRecursion(a,0,a.length-1,0,a.length-1,index);
        return index;

    }

    //对数组行列进行扩充，便于处理
    public static int[][] Matrix(){

        int[][] a =  {      {2,3,5,2,4,9,8},
                            {7,4,5,4,3,1,4},
                            {9,8,9,3,3,4,8},
                            {7,6,3,3,3,2,3},
                            {9,6,6,3,4,6,4},
                            {8,0,8,0,5,3,4},
                            {2,1,2,1,1,1,1}     };
        int [][] b = new int[a.length+2][a.length+2];

        for(int i = 0;i <b.length;i++)
            for(int j = 0;j < b[i].length;j++){
                if(i==0 || i ==a.length+1 || j==0 || j == a.length+1)
                    b[i][j]= 10;
                else
                    b[i][j]=a[i-1][j-1];
            }
        for(int i = 0;i <b.length;i++){
            for(int j = 0;j < b[i].length;j++)
                StdOut.printf("%2d ",b[i][j]);
            StdOut.println();
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


    //递归方法,会有栈溢出，未解决，待完善
    public static int[] MinLocalMatrixRecursion(int [][] data,int rs,int re,int cs,int ce,int []index){
        if(cs > ce || rs > re) {index[0] = -1;index[1] = -1;return index;}
        int cmid = (cs + ce)/2;
        int rmid = (rs + re)/2;

        if( data[rmid-1][cmid] > data[rmid][cmid] && data[rmid+1][cmid] > data[rmid][cmid]
                && data[rmid][cmid-1] > data[rmid][cmid] && data[rmid][cmid+1] > data[rmid][cmid])
            {  index[0] = rmid-1;index[1] = cmid-1;return index;  }

        if(data[rmid-1][cmid]+data[rmid][cmid-1] > data[rmid+1][cmid]+data[rmid][cmid+1])
            return MinLocalMatrixRecursion(data,rmid,re,cmid,ce,index);
        else if (data[rmid-1][cmid]+data[rmid][cmid-1] < data[rmid+1][cmid]+data[rmid][cmid+1])
            return MinLocalMatrixRecursion(data,rs,rmid,cs,cmid,index);
        else if (data[rmid-1][cmid]+data[rmid][cmid+1] > data[rmid][cmid-1]+data[rmid+1][cmid])
            return MinLocalMatrixRecursion(data,rs,rmid,cs,cmid,index);
        else //if (data[rmid-1][cmid]+data[rmid][cmid+1] < data[rmid][cmid-1]+data[rmid+1][cmid])
            return MinLocalMatrixRecursion(data,rmid,re,cmid,ce,index);
    }

}
