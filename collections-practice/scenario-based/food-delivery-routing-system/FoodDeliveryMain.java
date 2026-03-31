public class FoodDeliveryMain {
    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();
        service.addAgent(new Agent(1, "John Cena", "Downtown"));
        service.addAgent(new Agent(2, "Alexa Bliss", "Uptown"));
        service.placeOrder(new Order(101, "Mike Kanellis", "Downtown"));
        service.placeOrder(new Order(102, "Sarah Logan", "Uptown"));
        try {
            service.assignOrder();
            service.assignOrder();
        } catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
        }
        service.viewActiveDeliveries();
    }
}