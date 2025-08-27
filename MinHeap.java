class MinHeap{
    private final int[] heap;
    private  int size;
    private final  int capacity;

    public  MinHeap(int capacity) {
    this.size=0;
    this.capacity=capacity;
    this.heap=new int[capacity];
    }

   public  void insert(int value){
   if(size==capacity){
    throw new IllegalStateException("Heap  is full");
   }
   heap[size]=value;
   size++;
   heapifup(size-1);
   }

   private void heapifup(int index){
    while(index>0 && heap[index]<heap[parent(index)]){
        swap(index,parent(index));
        index=parent(index);
    }
   }
   private int parent(int index){
    return (index-1)/2;
   }
   private void swap(int i,int j){
    int temp=heap[i];
    heap[i]=heap[j];
    heap[j]=temp;
   }
   public  int extermin(){
    if(size==0){
        throw new IllegalStateException("heap is empty");
    }
      int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
   }
   
    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] < heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] < heap[largest]) {
            largest = right;
        }
        
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }
    private int leftChild(int index){
        return 2*(index-1)+1;
    }
    private int rightChild(int index){
        return 2*(index-1)+2;
    }
     public int getMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }
    
}




class Solution{
    
public static void main(String[] args){
MinHeap minHeap = new MinHeap(10);
minHeap.insert(6); 
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(1);
        minHeap.insert(7);
        minHeap.insert(255);

        System.out.println("Min element: " + minHeap.getMin());
        System.out.println("Extracted min: " + minHeap.extermin());
        System.out.println("Min element after extraction: " + minHeap.getMin());
        System.out.println("Extracted min: " + minHeap.extermin());
        System.out.println("Min element after sencond extractiion "+minHeap.getMin());
   }
}