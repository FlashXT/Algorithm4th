package CH1.CH1_4.CH1_4_21_MihaiPatrascu;

import java.util.Scanner;

public class FibonacciSequence{

        public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            int n=scan.nextInt();
            int []m=new int[n];
            m[0]=1;
            for(int i=0;i<n;i++){
                for(int j=i;j>0;j--){
                    m[j]=m[j-1]+m[j];
                }
                for(int k=i;k>-1;k--){
                    System.out.print(m[k]+" ");
                }
                System.out.println();
            }

        }
}
