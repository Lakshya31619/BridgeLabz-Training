public class Parcel {
    private Node head;
    public Parcel(){
        head = new Node("Packed");
        head.next = new Node("Shipped");
        head.next.next = new Node("In Transit");
        head.next.next.next = new Node("Delivered");
    }
    public void trackParcel() {
        Node current = head;
        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) System.out.print("->");
            current = current.next;
        }
        System.out.println();
    }
    public void addCheckpoint(String afterStage, String newStage){
        Node current = head;
        while (current != null) {
            if (current.name.equals(afterStage)) {
                Node checkpoint = new Node(newStage);
                checkpoint.next = current.next;
                current.next = checkpoint;
                return;
            }
            current = current.next;
        }
        System.out.println("Stage not found: " + afterStage);
    }
}