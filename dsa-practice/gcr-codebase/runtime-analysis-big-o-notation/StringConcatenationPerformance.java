public class StringConcatenationPerformance {
    private static final int N = 50000;
    public static void main(String[] args) {
        // String
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) {
            str = str + "a";
        }
        long end = System.nanoTime();
        System.out.println("String Time: " + (end - start) / 50000 + " ms");
        // StringBuilder
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 50000 + " ms");
        // StringBuffer
        start = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 50000 + " ms");
    }
}