//java递归实现求数组最大值
package CH1.CH1_3.ProblemList_Queue;

public class Recursion27_2 {

        public static void main(String []args){

            int [] a = {1,2,3,4,5,6,7,12,34,46,67,10};
            int n=12;
            System.out.println(max(a,0,n));
        }

        public static int max(int []arr,int from,int n){
            if(from == n-1)  return arr[from];//终止语句
            if (arr[from] >= max(arr,from+1,n))      return arr[from];
            else return max(arr,from+1,n);
        }

}