class ParcelTracker {
    private StageNode head;
    // Initialize default delivery chain
    public ParcelTracker() {
        head = new StageNode("Packed");
        head.next = new StageNode("Shipped");
        head.next.next = new StageNode("In Transit");
        head.next.next.next = new StageNode("Delivered");
    }
    // Forward tracking through stages
    public void trackParcel() {
        StageNode current = head;
        while (current != null) {
            System.out.print(current.stageName);
            if (current.next != null) System.out.print(" → ");
            current = current.next;
        }
        System.out.println();
    }
    // Add custom intermediate checkpoint
    public void addCheckpoint(String afterStage, String newStage) {
        StageNode current = head;
        while (current != null) {
            if (current.stageName.equals(afterStage)) {
                StageNode checkpoint = new StageNode(newStage);
                checkpoint.next = current.next;
                current.next = checkpoint;
                return;
            }
            current = current.next;
        }
        System.out.println("Stage not found: " + afterStage);
    }
    // Handle lost or missing parcel
    public boolean isParcelLost() {
        StageNode current = head;
        if (current == null) return true;
        while (current != null) {
            if (current.stageName == null) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}