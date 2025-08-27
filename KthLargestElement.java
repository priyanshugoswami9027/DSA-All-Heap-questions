
import java.util.PriorityQueue;

public class KthLargestElement {
    public static int KthLargest(int[] myArr,int k){
        k%=myArr.length;
        if(k==0)return 1;
        // Using the min heap to store the max element 
        PriorityQueue<Integer>MyQueue=new PriorityQueue<>();
        
        int i;
        for(i=0;i<k;i++){
          MyQueue.add(myArr[i]);
        }
        
        while(i<myArr.length){
            if(MyQueue.peek()<myArr[i]){
                MyQueue.poll();
                MyQueue.add(myArr[i]);
            }
            i++;
        }
        return MyQueue.peek();
    }

    public static void main(String[] args) {
       
        int[] arr={6,8,2,10,5,7,4,3};
        int k=77;
        System.out.println("The Final Kth Largest Element is :"+KthLargest(arr, k));

    }
}
