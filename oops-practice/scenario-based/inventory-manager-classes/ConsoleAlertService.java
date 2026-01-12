public class ConsoleAlertService implements AlertService {
    @Override
    public void sendLowStockAlert(Product product) {
        System.out.println("LOW STOCK ALERT: " + product.getName() + " (Remaining: " + product.getQuantity() + ")");
    }
}