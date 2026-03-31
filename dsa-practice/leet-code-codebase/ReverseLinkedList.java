class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class ReverseLinkedList {
    ListNode head;
    public void add(int data){
        ListNode newNode = new ListNode(data);
        if(head==null){
            head = newNode;
            return;
        }
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public void printList(){
        ListNode temp = head;
        while(temp!=null){
            System.out.println(temp.data+" ");
            temp = temp.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
    public static void main(String[] args) {
        ReverseLinkedList ll = new ReverseLinkedList();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.head = ll.reverseList(ll.head);
        ll.printList();
    }
}