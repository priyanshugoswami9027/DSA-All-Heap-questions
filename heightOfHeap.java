
import java.util.Scanner;

public class heightOfHeap {



    public static  int checkHeight(int n){
       if(n==1){
        return 1;
       }
       int count=0;
       while(n>1){
        n=n/2;
        count+=1;
       }
       return count;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.print("Enter the height of tree :");
       int n = sc.nextInt();
       System.out.println("the height of tree :"+checkHeight(n));
       

    }
}
