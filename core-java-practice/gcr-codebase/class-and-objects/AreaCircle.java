public class AreaCircle {
    // Circle Class
    static class Circle {
        // Attribute
        private double radius;
        // Constructor
        public Circle(double radius) {
            this.radius = radius;
        }
        // Method to calculate area
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
        // Method to calculate circumference
        public double calculateCircumference() {
            return 2 * Math.PI * radius;
        }
        // Method to display results
        public void displayDetails() {
            System.out.printf("Area of circle: %.4f\n", calculateArea());
            System.out.printf("Circumference of circle: %.4f\n", calculateCircumference());
        }
    }
    public static void main(String[] args) {
        // Create Circle object
        Circle circle = new Circle(2.5);
        // Display area and circumference
        circle.displayDetails();
    }
}