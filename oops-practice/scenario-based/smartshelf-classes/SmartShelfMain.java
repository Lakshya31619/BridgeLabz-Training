public class SmartShelfMain {
    public static void main(String[] args) {
        SmartShelf shelf = new SmartShelf(10);
        shelf.addBook("Java Programming");
        shelf.printShelf();
        shelf.addBook("Algorithms");
        shelf.printShelf();
    }
}