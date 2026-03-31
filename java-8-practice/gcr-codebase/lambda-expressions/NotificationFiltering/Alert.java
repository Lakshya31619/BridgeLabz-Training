package NotificationFiltering;
public class Alert {
    private String message;
    private String type;
    private int priority;
    public Alert(String message, String type, int priority) {
        this.message = message;
        this.type = type;
        this.priority = priority;
    }
    public String getMessage() {
        return message;
    }
    public String getType() {
        return type;
    }
    public int getPriority() {
        return priority;
    }
    @Override
    public String toString() {
        return "[" + type + "] " + message + " (Priority " + priority + ")";
    }
}