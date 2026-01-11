class ListNode{
    int data;
    ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class LinkedListCycle {
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
     public void createCycle(int pos) {
        if(head == null) return;
        ListNode temp = head;
        ListNode cycleNode = null;
        int index = 0;
        while(temp.next != null){
            if(index == pos){
                cycleNode = temp;
            }
            temp = temp.next;
            index++;
        }
        temp.next = cycleNode;
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        LinkedListCycle ll = new LinkedListCycle();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.printList();
        ll.createCycle(1);
        System.out.println("Cycle present : "+ll.hasCycle(ll.head));
    }
}