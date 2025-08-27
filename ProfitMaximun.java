import java.util.PriorityQueue;
public class ProfitMaximun {
    public static int MaximunProfit(int[] myarr,int total_ticket){
        PriorityQueue<Integer>MyQueue=new PriorityQueue<>((a,b)->b-a);

        for(int ticket:myarr){
            MyQueue.add(ticket);
        }
        int finalProfit=0;
        while(total_ticket!=0 && !MyQueue.isEmpty()){
            int sum=MyQueue.poll();
            finalProfit+=sum;
            sum--;
            if(sum!=0){
                MyQueue.add(sum);
            }
            total_ticket--;
        }
        return finalProfit;
    }

    public static void main(String[] args) {
        int[] arr={6,4};
        int ticket=3;
        System.out.println("the final profit for to sell the total ticket :" +MaximunProfit(arr, ticket));
        }
}
