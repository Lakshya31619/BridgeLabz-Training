public class BugManager {
    @BugReport(description = "NullPointerException on login")
    @BugReport(description = "UI misalignment on dashboard")
    public void fixBugs() {
        System.out.println("Fixing bugs...");
    }
}