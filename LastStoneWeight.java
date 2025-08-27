import java.util.PriorityQueue;
public class LastStoneWeight {
    public static int LastStone(int[] Stone){
    PriorityQueue<Integer>myStone=new PriorityQueue<>((a,b)->b-a);
    
    for(int ele:Stone){
        myStone.add(ele);
    }
    
    while(myStone.size()>1){
        int first=myStone.poll();
        int second=myStone.poll();
        int DistroyStone=first-second;
        if(DistroyStone!=0){
            myStone.add(DistroyStone);
        }
    }
    return myStone.isEmpty()?0:myStone.peek();
    }

    public static void main(String[] args) {
        int[] arr={2,7,4,1,8,1};
        // int[] arr={2,2,1000};
        System.err.println("the final result of Last Stone weight :"+LastStone(arr));
    }
}
