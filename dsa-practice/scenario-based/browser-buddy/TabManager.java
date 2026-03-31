import java.util.Stack;
class TabManager {
    private Stack<BrowserTab> closedTabs = new Stack<>();
    private BrowserTab activeTab;
    public void openNewTab() {
        activeTab = new BrowserTab();
    }
    public void closeCurrentTab() {
        if (activeTab != null) {
            closedTabs.push(activeTab);
            activeTab = null;
        }
    }
    public void restoreClosedTab() {
        if (!closedTabs.isEmpty()) {
            activeTab = closedTabs.pop();
        }
    }
    public BrowserTab getActiveTab() {
        return activeTab;
    }
}