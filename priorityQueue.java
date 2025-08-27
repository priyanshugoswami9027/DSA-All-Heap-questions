import java.util.ArrayList;

class MinHeap {
    private ArrayList<Integer> heap1;

    public MinHeap() {
        heap1 = new ArrayList<>();
    }

    public void insert(int val) {
        heap1.add(val);
        heapifyUp(heap1.size() - 1);
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException("Heap is Empty");

        int min = heap1.get(0);
        int last = heap1.remove(heap1.size() - 1);
        if (!isEmpty()) {
            heap1.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is Empty");
        return heap1.get(0);
    }

    public boolean isEmpty() {
        return heap1.size() == 0;
    }

    private void heapifyUp(int index) {
        int parent = (index - 1) / 2;

        while (index > 0 && heap1.get(index) < heap1.get(parent)) {
            swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        while (true) {
            int smallest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < heap1.size() && heap1.get(left) < heap1.get(smallest)) {
                smallest = left;
            }

            if (right < heap1.size() && heap1.get(right) < heap1.get(smallest)) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap1.get(i);
        heap1.set(i, heap1.get(j));
        heap1.set(j, temp);
    }

    public void printHeap() {
        System.out.println(heap1);
    }
}

public class priorityQueue {
    public static void main(String[] args) {
        MinHeap pq = new MinHeap();
        pq.insert(10);
        pq.insert(20);
        pq.insert(4);
        pq.insert(50);
        pq.insert(15);
        pq.insert(2);

        System.out.println("Priority Queue (Min-Heap):");
        System.out.println("Remove the element: " + pq.remove());
        System.out.println("Peek element: " + pq.peek());
        System.out.println("Updated Heap: ");
        pq.printHeap();
    }
}
