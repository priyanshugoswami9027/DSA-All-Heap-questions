class SortHeap{
    private int[] myArr;
    private int n;

    public SortHeap(int[] myArr,int n) {
       this.myArr=myArr;
       this.n=n;
    }

    private void BuildMaxHeap(int myArr[],int n){

        for(int i=n/2-1;i>=0;i--){
            HeapifyDown(myArr,i,n);
        }
    }
    private void HeapifyDown(int[] myArr,int index,int n ){
        int largest1=index;
        int left=2*index+1;
        int right=2*index+2;
        if(left<n && myArr[left]>myArr[largest1]){
            largest1=left;

        }
        if(right<n && myArr[right]>myArr[largest1]){
            largest1=right;

        }
        if(largest1!=index){
            swap(largest1,index);
            HeapifyDown(myArr, largest1, n);
        }

    }
    private void swap(int i,int j){
        int temp=myArr[i];
        myArr[i]=myArr[j];
        myArr[j]=temp;
    }
    public void print(int[] myArr,int n){
        for(int i=0;i<n;i++){
            System.out.println("the all element is"+ myArr[i]);
        }
    }
    private void sortheap1(int[] heap,int size){
    for(int i=size-1;i>0;i--){
        swap(heap[i], heap[0]);
        HeapifyDown(myArr, i, 0);;
    }
    }


}


public class SortMaxHeap {
    public static void main(String[] args) {
         int[] myArr={10,3,8,9,5,12,13,18,14,70};
        SortHeap sortheap=new SortHeap(myArr, 10);
        sortheap.print(myArr,10);
        
       
    }
}
