package Chapter_1;

public class CH1_P15 {
    public static void main(String [] args){
        int []a={1,2,3,4,3,2,4,5,5,6,2,1,4,5};
      int [] b=histgram(a,10);
      for(int k:b)
          System.out.println(k);

    }
    public static int[] histgram(int a[],int M){
        /*返回的数组中第i个元素的值为整数i再参数数组中出现的次数；
         *若a[]中的值均在0到M-1之间，返回数组中所有元素之和应该等于a.length
         */
        int []result=new int[M];
        int count=0;
        for(int i=0;i<M;i++){
            count=0;
            for(int j=0;j<a.length;j++){
                if(a[j]==i)count++;
            }
            result[i]=count;
        }
        return result;
    }
}
