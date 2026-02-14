public class Agent {
    private int agentId;
    private String name;
    private String currentLocation;
    private boolean available;
    public Agent(int agentId, String name, String currentLocation) {
        this.agentId = agentId;
        this.name = name;
        this.currentLocation = currentLocation;
        this.available = true;
    }
    public boolean isAvailable() {
        return available;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void assignOrder() {
        this.available = false;
    }
    public void completeOrder() {
        this.available = true;
    }
    @Override
    public String toString() {
        return "Agent ID: " + agentId + ", Name: " + name + ", Location: " + currentLocation + ", Available: " + available;
    }
}