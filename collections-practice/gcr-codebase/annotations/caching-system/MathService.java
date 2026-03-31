public class MathService {
    @CacheResult
    public int slowSquare(int number) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Computing square...");
        return number * number;
    }
}