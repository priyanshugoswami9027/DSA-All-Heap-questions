
import java.util.PriorityQueue;

public class MedianInAStream {
    static PriorityQueue<Integer>LeftMaxHeap= new PriorityQueue<>((a,b)->b-a);
    static PriorityQueue<Integer>RightMinHeap= new PriorityQueue<>();

    public static void insertHeap(int x){
        if(LeftMaxHeap.isEmpty()){
            LeftMaxHeap.add(x);
            return;
        }
        if(x>LeftMaxHeap.peek()){
            RightMinHeap.add(x);
        }
        else{
            LeftMaxHeap.add(x);
        }
        balanceHeap();

    }

    public static void balanceHeap(){
        if(RightMinHeap.size()>LeftMaxHeap.size()){
            LeftMaxHeap.add(RightMinHeap.poll());
        }
        else{
            if(RightMinHeap.size()<LeftMaxHeap.size()-1){
                RightMinHeap.add(LeftMaxHeap.poll());
            }
        }
    }
    public static double getMax(){
        if(LeftMaxHeap.size()>RightMinHeap.size()){
            return LeftMaxHeap.peek();
        }
        double ans=LeftMaxHeap.peek()+RightMinHeap.peek();
        ans/=2;
        return ans;

    }

    public static void main(String[] args) {
        int[] arr={7,11,4,9,15,2,1,18};
        for(int ele:arr){
            insertHeap(ele);
            System.out.println("the final median of all element is :"+getMax());
        } 

    }

}
