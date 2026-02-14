public class Session {
    private String sessionId;
    public Session(String sessionId) {
        this.sessionId = sessionId;
    }
    public String getSessionId() {
        return sessionId;
    }
    @Override
    public String toString() {
        return "Session ID: " + sessionId;
    }
}