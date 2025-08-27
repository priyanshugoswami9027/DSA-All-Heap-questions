import java.util.PriorityQueue;

public class magicianChocolate {
    public static long totalChocolate(int[] myArr,int A){
    PriorityQueue<Integer>myPq=new PriorityQueue<>((a,b)->b-a);
    
    for(int chocolate:myArr){
        myPq.add(chocolate);
    }
    long howMuchEat=0;
    while(A!=0 && (!myPq.isEmpty())){
    int sum=myPq.poll();
    howMuchEat+=sum;
    if(sum/2!=0){
        myPq.add(sum/2);
    }
    A--;
    }
    return howMuchEat%100000007;
    }

    public static void main(String[] args) {
        int[] arr={2,4,8,6,10};
        int A=5;
        System.err.println("the maximum number of chocolateto eat :"+totalChocolate(arr, A));
    }

}
