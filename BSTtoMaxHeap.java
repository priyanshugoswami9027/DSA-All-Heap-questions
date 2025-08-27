class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data=data;
        this.left=null;
        this.right=null;
        
    }
    
}
public class BSTtoMaxHeap {
    public static void main(String[] args) {
        // int[] arr = {13, 10, 5, 6, 2, 3};
        Integer[] arr = {8,5,null,1,6,null,3,null,7,2,4};
        Node root = insertLevelOrder(arr, null, 0);
        inOrder(root, arr,0);
        PostOredr(root, arr,0);
        

    }
    // public static void printtree(Node node ){
    //     if (node == null) {
    //         return;
    //     }
    //     System.err.println("all tree node " + node.data);
    //     printtree(node.left);
    //     printtree(node.right);

    // }
    public static void inOrder(Node node, Integer[] arr,int index) {
        if (node == null) {
            return;
        }
        inOrder(node.left, arr,index);
        arr[index]=node.data;
        inOrder(node.right, arr,index + 1);
    }
    public static void PostOredr(Node node, Integer[] arr,int index) {
        if (node == null) {
            return;
        }
        PostOredr(node.left, arr,index);
        PostOredr(node.right, arr,index);
        arr[index]=node.data;
        index++;
    }
    
    public static Node insertLevelOrder(Integer[] arr, Node root, int i) {
        if (i < arr.length && arr[i] != null) {
            Node temp = new Node(arr[i]);
            temp.left = insertLevelOrder(arr, temp.left, 2 * i + 1);
            temp.right = insertLevelOrder(arr, temp.right, 2 * i + 2);
            return temp;
        }
        return null;
    }
}
