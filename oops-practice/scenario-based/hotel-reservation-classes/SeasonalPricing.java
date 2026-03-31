public class SeasonalPricing implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int days) {
        return basePrice * days * 1.2; // 20% seasonal increase
    }
}