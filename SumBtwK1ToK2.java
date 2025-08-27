
import java.util.PriorityQueue;

public class SumBtwK1ToK2 {
    public static int SumOfElementK1ToK2(int[] myArr,int k1,int k2){
        PriorityQueue<Integer>pq1=new PriorityQueue<>((a,b)->b-a);
         PriorityQueue<Integer>pq2=new PriorityQueue<>((a,b)->b-a);
        
         // add element of queue to k1
         for(int i=0;i<k1;i++){
            pq1.add(myArr[i]);
         }
         // add element of queue to k2-1
         for(int i=0;i<k2-1;i++){
            pq2.add(myArr[i]);
         }
         // store the min element in the k1
         for(int i=k1;i<myArr.length;i++){
            if(pq1.peek()>myArr[i]){
                pq1.poll();
                pq1.add(myArr[i]);
            }
         } 
         // store the min element in the k2-1
         for(int i=k2-1;i<myArr.length;i++){
            if(pq2.peek()>myArr[i]){
                pq2.poll();
                pq2.add(myArr[i]);
            }
         }

         /// find sum pq1 and pq2 and subtract
         int sum1=0;
         int sum2=0;
         while(!pq1.isEmpty()){
            sum1+=pq1.poll();
         }
         while(!pq2.isEmpty()){
            sum2+=pq2.poll();
         }
         return sum2-sum1;

    }

    public static void main(String[] args) {
       
        int[] arr={20,8,22,4,12,10,14};
        int k1=3;
        int k2=6;
        System.out.println("The Final Answer sum of  btw K1 to K2 Largest Element is :"+SumOfElementK1ToK2(arr, k1, k2));

    }
}
