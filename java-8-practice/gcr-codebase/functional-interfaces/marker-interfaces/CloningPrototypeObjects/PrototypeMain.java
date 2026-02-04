public class PrototypeMain {
    public static void main(String[] args) {
        try {
            ProductPrototype original = new ProductPrototype(101, "Laptop", 75000);
            ProductPrototype copy = (ProductPrototype) original.clone();
            System.out.println("Original: " + original);
            System.out.println("Cloned:   " + copy);
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported");
        }
    }
}