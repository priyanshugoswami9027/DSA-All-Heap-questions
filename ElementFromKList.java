
import java.util.PriorityQueue;

public class ElementFromKList {
    public static boolean isPossible(int[] target){
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        int Sum=0;
        //store the element in the priorityQueue
       
            for (int i = 0; i < target.length; i++) {
                pq.add(target[i]);
                Sum+=target[i];
            }

            int MaxEle,RemEle,Element;

        // ham jab tak while loop chlayege jab tak priorityQueue ke sab element 1 na ho jaye
        while(pq.peek()!=1){
            MaxEle=pq.poll();
            RemEle=Sum-MaxEle;
            if(RemEle<=0 || RemEle>=MaxEle){
                return false;
            }
            //cndition one 
            // Element=MaxEle-RemEle;
            //condition second to reduce time limit 
            Element=MaxEle%RemEle;
            if(Element==0){
                if(RemEle!=1){
                    return false;
                }
                else{
                    return true;
                }
            }
            Sum=RemEle+Element;
            pq.add(Element);
        }
        return true;
    }
    public static void main(String[] args) {
        // int[] arr={10,25,1,37};
        // int[] arr={9,3,5};
        int [] arr={1,2,6};
        boolean ans=isPossible(arr);
        System.out.println("check the array to return 1's "+ans);
    }
}
