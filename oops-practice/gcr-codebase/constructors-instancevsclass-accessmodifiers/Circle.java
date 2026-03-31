public class Circle {
    // Attribute (encapsulated)
    private double radius;
    // Default constructor
    public Circle() {
        this(1.0);
    }
    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    // Getter
    public double getRadius() {
        return radius;
    }
    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    public static void main(String[] args) {
        // Using default constructor
        Circle c1 = new Circle();
        System.out.println("Circle 1 Radius: " + c1.getRadius());
        System.out.println("Circle 1 Area: " + c1.calculateArea());
        System.out.println();
        // Using parameterized constructor
        Circle c2 = new Circle(5.0);
        System.out.println("Circle 2 Radius: " + c2.getRadius());
        System.out.println("Circle 2 Area: " + c2.calculateArea());
    }
}