class BrowserTab {
    private PageNode head;
    private PageNode current;
    // Visit new page
    public void visit(String url) {
        PageNode newPage = new PageNode(url);
        if (head == null) {
            head = current = newPage;
            return;
        }
        // Remove forward history
        current.next = null;
        newPage.prev = current;
        current.next = newPage;
        current = newPage;
    }
    // Navigate backward
    public String back() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
        return current.url;
    }
    // Navigate forward
    public String forward() {
        if (current != null && current.next != null) {
            current = current.next;
        }
        return current.url;
    }
    public String getCurrentPage() {
        return current != null ? current.url : "No Page";
    }
}