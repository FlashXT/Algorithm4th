package CH1.CH1_4.TheMinElement_of_local;

import edu.princeton.cs.algs4.StdOut;


/*************************************************************************************
 * 算法思路：在TheMinElementOfLocalinMatrixFast二分算法的启发下，从矩阵中心开始，将矩阵四等分，
 * 并递归处理,每次比较矩阵中心元素与周围元素，并将该元素所在的行列元素逐一比较，然后递归进行处理；
 *
 **************************************************************************************/

public class TheMinElementOfGlobalinMatrixFaster {
    public static void main(String[] args) {
        int[][] data = Matrix();
        int []index =  MatrixMinLocal(data);
        StdOut.println((index[0]-1)+","+(index[1]-1));

    }

    public static int[] MatrixMinLocal(int[][] a) {

        int[] index = {a.length/2,a.length/2};
        MinLocalMatrixRecursion(a,0,a.length-1,0,a.length-1,index);
        return index;

    }

    //对数组行列进行扩充，便于处理
    public static int[][] Matrix(){

        int[][] a =  {      {2,3,5,2,4,9,8},
                            {7,4,5,4,3,3,4},
                            {9,8,9,3,3,4,8},
                            {7,6,3,3,3,2,3},
                            {9,6,6,3,4,6,4},
                            {8,1,8,2,5,3,4},
                            {2,1,2,1,1,1,1} };
        int [][] b = new int[a.length+2][a.length+2];

        for(int i = 0;i <b.length;i++)
            for(int j = 0;j < b[i].length;j++){
                if(i==0 || i ==a.length+1 || j==0 || j == a.length+1)
                    b[i][j]= 10;
                else
                    b[i][j]=a[i-1][j-1];
            }
        for(int i = 0;i <a.length;i++){
            for(int j = 0;j < a[i].length;j++)
                StdOut.printf("%2d ",a[i][j]);
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


    //递归方法,分治法，完美求出全局最小解，Fighting！
    public static int[] MinLocalMatrixRecursion(int [][] data,int rs,int re,int cs,int ce,int []index){
        if(ce - cs < 2 && re - rs < 2) return index;
        int rmid = (rs + re)/2;
        int cmid = (cs + ce)/2;
//        StdOut.println(rmid+","+cmid);
       // StdOut.println(rmid+" "+cmid);
        for(int i = 1; i < data[rmid].length-1; i++ ){
            if( data[rmid-1][i] > data[rmid][i] && data[rmid+1][i] > data[rmid][i]
                    && data[rmid][i-1] > data[rmid][i] && data[rmid][i+1] > data[rmid][i]){
                if(data[rmid][i] < data[index[0]][index[1]])
                               {index[0]= rmid;index[1]= i;}
            }
            if( data[i-1][cmid] > data[i][cmid] && data[i+1][cmid] > data[i][cmid]
                    && data[i][cmid-1] > data[i][cmid] && data[i][cmid+1] > data[i][cmid]){
                if(data[i][cmid] < data[index[0]][index[1]])
                {index[0]= i;index[1]= cmid;}
            }
        }
        StdOut.println(index[0]+","+index[1]);
//        if( data[rmid-1][cmid] > data[rmid][cmid] && data[rmid+1][cmid] > data[rmid][cmid]
//                && data[rmid][cmid-1] > data[rmid][cmid] && data[rmid][cmid+1] > data[rmid][cmid]){
//            if(data[rmid][cmid] <= data[index[0]][index[1]])
//                       {index[0]= rmid;index[1]= cmid;}
//        }

        MinLocalMatrixRecursion(data,rs,rmid,cmid,ce,index);
        MinLocalMatrixRecursion(data,rs,rmid,cs,cmid,index);
        MinLocalMatrixRecursion(data,rmid,re,cs,cmid,index);
        MinLocalMatrixRecursion(data,rmid,re,cmid,ce,index);

        return index;

    }
//
}
