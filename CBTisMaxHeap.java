class BinaryTree{
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }
    
    Node root;
}
public class CBTisMaxHeap {


    public static int CountNode(BinaryTree.Node root){
        if(root!=null)return 0;

        return 1+CountNode(root.left)+CountNode(root.right);

    }

   public static boolean CBT(BinaryTree.Node root,int index,int TotalNode){
    if(root!=null)return true;
    
    if(index>=TotalNode)return false;

    return CBT(root.left, 2*index+1, TotalNode) && CBT(root.right, 2*index+2, TotalNode);

   }
   public static boolean isHeap(BinaryTree.Node root){
   int TotalNode=CountNode(root);
   //check the complete binary tree
   if(!CBT(root,0,TotalNode)) return false;

     return isMaxHeap(root);
   }



    public static boolean isMaxHeap(BinaryTree.Node root){
        // An empty tree is a max heap
        if (root.left != null) {
            if(root.data < root.left.data) {
                return false;
            }
            if(!isMaxHeap(root.left)){
                return false;
            }
        }
        // check the right child 
        if (root.right != null) {
            if(root.data < root.right.data) {
                return false;
            }
            return isMaxHeap(root.right);
        }
        return true;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node root = null;
        int[] arr = {10, 5, 6, 2, 3};
        root = insertLevelOrder(arr, tree, 0);
        boolean result=isHeap(root);
        System.out.println("check the this binary tree is max heap :"+ result);
        // Example usage: print the root node's data if not null
        if (root != null) {
            System.out.println("Root node value: " + root.right.data);
        }
    }

    // Method to insert nodes in level order
    public static BinaryTree.Node insertLevelOrder(int[] arr, BinaryTree tree, int i) {
        BinaryTree.Node root = null;
        if (i < arr.length) {
            root = tree.new Node(arr[i]);
            root.left = insertLevelOrder(arr, tree, 2 * i + 1);
            root.right = insertLevelOrder(arr, tree, 2 * i + 2);
        }
        return root;
    }
}
