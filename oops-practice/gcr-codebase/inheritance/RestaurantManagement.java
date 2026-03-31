// Superclass
class Person {
    protected String name;
    protected int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
// Interface
interface Worker {
    void performDuties();
}
// Subclass Chef
class Chef extends Person implements Worker {
    public Chef(String name, int id) {
        super(name, id);
    }
    @Override
    public void performDuties() {
        System.out.println("Chef prepares meals and manages the kitchen.");
    }
}
// Subclass Waiter
class Waiter extends Person implements Worker {
    public Waiter(String name, int id) {
        super(name, id);
    }
    @Override
    public void performDuties() {
        System.out.println("Waiter takes orders and serves customers.");
    }
}
public class RestaurantManagement {
    public static void main(String[] args) {
        Worker chef = new Chef("Gaur Son", 1001);
        Worker waiter = new Waiter("Rohit Bhai", 6);
        chef.performDuties();
        waiter.performDuties();
    }
}