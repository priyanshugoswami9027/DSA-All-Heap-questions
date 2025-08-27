import java.util.PriorityQueue;

public class SmallestRangeCovering {
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

    public static int[] SmallestRange(int[][] arr){
        PriorityQueue<ArrayNode>pq=new PriorityQueue<>((a,b)->a.value-b.value);

        int max=Integer.MIN_VALUE;
        int min;

        for (int i = 0; i <arr.length; i++) {
            pq.add(new ArrayNode(arr[i][0], i, 0));
            max=Math.max(max, arr[i][0]);
        }
        min=pq.peek().value;

        int[] ans=new int[2];
        ans[0]=min;
        ans[1]=max;

        ArrayNode temp;
        int ele,row,col;
        while(pq.size()==arr.length){
        
        temp=pq.poll();
        ele=temp.value;
        row=temp.row;
        col=temp.col;

        if(col+1<arr[row].length){
            col++;
            pq.add(new ArrayNode(arr[row][col], row, col));
            max=Math.max(max,arr[row][col]);
            min=pq.peek().value;

            if(max-min<ans[1]-ans[0]){
                ans[0]=min;
                ans[1]=max;
            }
        }
        }
        return ans;

    }
     public static void main(String[] args) {
        int[][] arr={
            {3,7,8},
            {1,2,4,6,12},
            {7,8,10,14},
            
        };
         int[] ans=SmallestRange(arr);
         System.out.println("the smallest range is : ["+ans[0]+ ","+ans[1]+"]");
        
    }
}
