public class Person {
    // Attributes
    private String name;
    private int age;
    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }
    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // Copy constructor
    public Person(Person other) {
        if (other != null) {
            this.name = other.name;
            this.age = other.age;
        }
    }
    // Getters
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public static void main(String[] args) {
        // Original object
        Person p1 = new Person("Alice", 25);
        // Clone using copy constructor
        Person p2 = new Person(p1);
        // Display both objects
        System.out.println("Original Person:");
        System.out.println("Name: " + p1.getName() + ", Age: " + p1.getAge());
        System.out.println("Cloned Person:");
        System.out.println("Name: " + p2.getName() + ", Age: " + p2.getAge());
    }
}