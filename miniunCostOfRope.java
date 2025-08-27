import java.util.PriorityQueue;

public class miniunCostOfRope {

    public static long MiniCost(long[] myArr){

       PriorityQueue<Long>pq=new PriorityQueue<>();

      for(long rope:myArr){
        pq.add(rope);
      }
       
      long cost=0;
      while(pq.size()>1){
      long first=pq.poll();
      long second=pq.poll();
      long sum=first+second;
      cost+=sum;
      pq.add(sum);
      }
        
      return cost;
    }
    public static void main(String[] args) {
        long []arr={4,2,7,6,5,1};
        System.out.println("Minimum cost of heap :"+MiniCost(arr));
    }
}
