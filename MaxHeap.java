class MaxHeap {
    private final int[] heap;
    private int size;
    private final int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    public int getMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    private void heapifyUp(int index) {
        while (index > 0 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.println("the all element"+ heap[i]);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }
    private void sortheap1(int[] heap,int size){
    for(int i=size-1;i>0;i--){
        swap(heap[i], heap[0]);
        heapifyDown(i);
    }
    }
}
 
 
 class Solution {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(255);

        System.out.println("Max element: " + maxHeap.getMax());
        System.out.println("Extracted max: " + maxHeap.extractMax());
        System.out.println("Max element after extraction: " + maxHeap.getMax());
        System.out.println("Extracted max: " + maxHeap.extractMax());
        System.out.println("Max element after sencond extractiion "+maxHeap.getMax());
        maxHeap.print();

    }
}
