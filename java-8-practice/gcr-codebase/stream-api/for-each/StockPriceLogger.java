import java.util.*;
public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> stockPrices = Arrays.asList(2450.75, 2461.30, 2448.90, 2475.60, 2480.10);
        stockPrices.stream()
                .forEach(price ->
                        System.out.println("Stock Price Update: ₹" + price)
                );
    }
}