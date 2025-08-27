
import java.util.PriorityQueue;

public class KthsmallestElement {
    public static  int KthElement(int[] myArr,int k){
        k%=myArr.length;
        PriorityQueue<Integer>MyQueue=new PriorityQueue<>((a,b)->b-a);
        int i;
        for(i=0;i<k;i++){
            MyQueue.add(myArr[i]);
        }

        while(i<myArr.length){
            if(MyQueue.peek()>myArr[i]){
                MyQueue.poll();
                MyQueue.add(myArr[i]);
            }
            i++;
        }
        return MyQueue.peek();
    }

    public static void main(String[] args) {
        // int[] arr={10,3,7,4,8,9,2,6};
        int[] arr={7,10,4,3,20,15};
        int k=25;
        System.out.println("The Final Kth Smallest Element is :"+KthElement(arr,k));

    }
}
