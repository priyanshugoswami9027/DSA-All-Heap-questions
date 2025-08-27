
import java.util.ArrayList;

public class MergeTwoMaxHeap {

    public static void heapifyDown(ArrayList<Integer>arr,int index,int n){
        int largest=index;
        int left=2*index+1;
        int right=2*index+2;
       
        if(left<n && arr.get(left)>arr.get(largest)){
            largest=left;
        }
         if(right<n && arr.get(right)>arr.get(largest)){
            largest=right;
        }

        if(largest!=index){
            int temp=arr.get(index);
            arr.set(index, arr.get(largest));
            arr.set(largest,temp);
            heapifyDown(arr, largest, n);
            

        }
    }
    
    public static ArrayList<Integer> MergeTwoHeap(int[] myArr1,int[] myArr2){
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<myArr1.length;i++){
            list.add(myArr1[i]);
        }
        for(int i=0;i<myArr2.length;i++){
            list.add(myArr2[i]);
        }

        //conver the array in to Max Heap 
        int n=list.size();
        for(int i=n/2-1;i>=0;i--){
            heapifyDown(list,i,n);
        }
        return list;

    }

    public static void main(String[] args) {
        int[] arr1={10,5,6,2};
        int[] arr2={12,7,9};
        
        System.out.println("The Final Merge two  Element is :"+MergeTwoHeap(arr1, arr2));

    }
}
