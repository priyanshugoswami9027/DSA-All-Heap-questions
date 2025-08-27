
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArr {
    static class ArrayNode{
        int value;
        int row;
        int col;

        public ArrayNode(int value,int row,int col){
        this.value=value;
        this.row=row;
        this.col=col;
        }
    }
    public static ArrayList<Integer> MergeKArray(int[][] arr,int k){

        /// create  the arraylist to store the answer
    ArrayList<Integer>ans=new ArrayList<>();
    
    PriorityQueue<ArrayNode>pq=new PriorityQueue<>((a,b)->a.value-b.value);

   // store the first element  in  the queue 
   for (int i = 0; i < k; i++) {
       if(arr[i].length>0){
        pq.add(new ArrayNode(arr[i][0], i, 0));
       }
   }
       // check the all ellement in the priority Queue
       while(!pq.isEmpty()){
        ArrayNode current=pq.poll();
        ans.add(current.value);
        int i=current.row;
        int j=current.col;
        if(j+1<arr[i].length){
        pq.add(new ArrayNode(arr[i][j+1], i, j+1));
      
       }
    }
    return ans;
   
    }

    public static void main(String[] args) {
        int[][] arr={
            {3,4,5,11},
            {1,6,7,14},
            {4,5,8,13},
            {6,9,10,12}
        };
        List<Integer>res=MergeKArray(arr,arr.length);
        for(int val:res){
            System.out.print(val+" ");
        }
    }
}
