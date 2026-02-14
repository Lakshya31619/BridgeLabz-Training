import java.util.*;
public class DeliveryService {
    private Queue<Order> orderQueue = new LinkedList<>();
    private List<Agent> agents = new ArrayList<>();
    private Map<Order, Agent> activeDeliveries = new HashMap<>();
    public void addAgent(Agent agent) {
        agents.add(agent);
    }
    public void placeOrder(Order order) {
        orderQueue.offer(order);
        System.out.println("Order added to queue: " + order);
    }
    public void assignOrder() throws NoAgentAvailableException {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders to assign.");
            return;
        }
        Order order = orderQueue.peek();
        Agent availableAgent = null;
        for (Agent agent : agents) {
            if (agent.isAvailable()) {
                availableAgent = agent;
                break;
            }
        }
        if (availableAgent == null) {
            throw new NoAgentAvailableException("No delivery agents available!");
        }
        availableAgent.assignOrder();
        activeDeliveries.put(order, availableAgent);
        orderQueue.poll();
        System.out.println("Assigned " + order + " to " + availableAgent);
    }
    public void cancelOrder(int orderId) {
        orderQueue.removeIf(order -> order.getOrderId() == orderId);
        System.out.println("Order " + orderId + " cancelled (if present in queue).");
    }
    public void viewActiveDeliveries() {
        if (activeDeliveries.isEmpty()) {
            System.out.println("No active deliveries.");
            return;
        }
        System.out.println("Active Deliveries:");
        for (Map.Entry<Order, Agent> entry : activeDeliveries.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}