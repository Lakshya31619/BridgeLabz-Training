public class Roundabout {
    private Vehicle head = null;
    // Add vehicle to circular linked list
    public void addVehicle(int id) {
        Vehicle newVehicle = new Vehicle(id);
        if (head == null) {
            head = newVehicle;
            head.next = head;
        } else {
            Vehicle temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newVehicle;
            newVehicle.next = head;
        }
        System.out.println("Vehicle " + id + " entered the roundabout.");
    }
    // Remove vehicle from circular linked list
    public void removeVehicle(int id) {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }
        Vehicle curr = head;
        Vehicle prev = null;
        do {
            if (curr.id == id) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else if (curr == head) {
                    Vehicle last = head;
                    while (last.next != head)
                        last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Vehicle " + id + " exited the roundabout.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
        System.out.println("Vehicle " + id + " not found in roundabout.");
    }
    // Print roundabout state
    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }
        Vehicle temp = head;
        System.out.print("Roundabout Vehicles: ");
        do {
            System.out.print(temp.id + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }
}