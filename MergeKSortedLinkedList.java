 import java.util.PriorityQueue;

public class MergeKSortedLinkedList {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val=val;
        }   
    }

    public static ListNode MergeKList(ListNode[] list){
    // create a priority queue to sort the listnode in the with make costumize priority queue 
    PriorityQueue<ListNode>pq=new PriorityQueue<>((a,b)->Integer.compare(a.val, b.val));
    // sort first k node to the priority queue 
    for(ListNode node:list){
        if(node!=null){
            pq.add(node);
        }
    }
    // create the dummy node to the store the zero value because dummay node next point the all listnode element 
    ListNode dummy=new ListNode(0);
    ListNode tail=dummy;
  /// and one by one check the all node in the linked list or node jab tak vo khali na ho jaye 
    while(!pq.isEmpty()){
        ListNode temp=pq.poll();
        tail.next=temp;
       tail=tail.next;
   // chekc the temp node temp node is not empty than store the element
       if(temp.next!=null){
        pq.add(temp.next);
       }

    }
    return dummy.next;
    
    }
     
    // print the all node the screen 
    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val);
           if(head.next!=null)System.out.print("--> ");
           head=head.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListNode l1=new ListNode(4);
        l1.next=new ListNode(7);
        l1.next.next=new ListNode(11);

         ListNode l2=new ListNode(3);
        l2.next=new ListNode(10);
        // l2.next.next=new ListNode(5);

         ListNode l3=new ListNode(2);
        l3.next=new ListNode(8);
        l3.next.next=new ListNode(13);

         ListNode l4=new ListNode(5);
        l4.next=new ListNode(9);
        // l4.next.next=new ListNode(5);

         ListNode l5=new ListNode(1);
        // l5.next=new ListNode(4);
        // l5.next.next=new ListNode(5);

         ListNode l6=new ListNode(6);
        l6.next=new ListNode(12);
        // l6.next.next=new ListNode(5);


        ListNode[] list={l1,l2,l3,l4,l5,l6};
        ListNode result=MergeKList(list);
        System.out.print("Merge the srted linked list :");
        printList(result);
    }
}
