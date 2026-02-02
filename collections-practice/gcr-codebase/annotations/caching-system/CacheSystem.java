public class CacheSystem {
    public static void main(String[] args) {
        MathService service = new MathService();
        System.out.println("First call:");
        System.out.println(CacheManager.execute(service, "slowSquare", 5));
        System.out.println("\nSecond call (same input):");
        System.out.println(CacheManager.execute(service, "slowSquare", 5));
        System.out.println("\nThird call (different input):");
        System.out.println(CacheManager.execute(service, "slowSquare", 6));
    }
}