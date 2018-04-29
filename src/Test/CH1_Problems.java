package Test;

public class CH1_Problems {
    public static void main(String[] args) {
        int [][]a={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        for(int i=0;i<a.length;i++) {
            for (int j = 0; j < a[i].length; j++)
                System.out.printf("%3d\t", a[i][j]);
            System.out.println();
        }
        Martix(a);
    }
    public static void Martix(int [][]a) {
        int temp = 0;
        int [][]b=new int[a[0].length][a.length];
        for (int i = 0; i < b.length; i++)
            for (int j = 0; j < b[i].length; j++)
                    b[i][j] = a[j][i];

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++)
                System.out.printf("%3d\t", b[i][j]);
            System.out.println();

        }
    }
}