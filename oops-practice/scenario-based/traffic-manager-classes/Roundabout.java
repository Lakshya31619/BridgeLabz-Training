class Roundabout {
    private Vehicles head = null;
    public void addVehicle(String number) {
        Vehicles newVehicle = new Vehicles(number);
        if (head == null) {
            head = newVehicle;
            newVehicle.next = head;
        } else {
            Vehicles temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newVehicle;
            newVehicle.next = head;
        }
        System.out.println("Vehicle " + number + " entered roundabout");
    }
    public void removeVehicle(String number) {
        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }
        Vehicles curr = head;
        Vehicles prev = null;
        do {
            if (curr.number.equals(number)) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else {
                    if (curr == head) {
                        Vehicles last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = head.next;
                        last.next = head;
                    } else {
                        prev.next = curr.next;
                    }
                }
                System.out.println("Vehicle " + number + " exited roundabout");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
        System.out.println("Vehicle not found in roundabout");
    }
    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }
        System.out.print("Roundabout: ");
        Vehicles temp = head;
        do {
            System.out.print(temp.number + " → ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }
}