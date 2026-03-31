public class BrowserBuddyMain {
    public static void main(String[] args) {
        TabManager manager = new TabManager();
        manager.openNewTab();
        BrowserTab tab = manager.getActiveTab();
        tab.visit("leetcode.com");
        tab.visit("codeforces.com");
        tab.visit("hackerrank.com");
        System.out.println(tab.back());     
        System.out.println(tab.back());    
        System.out.println(tab.forward());   
        manager.closeCurrentTab();
        manager.restoreClosedTab();
        System.out.println(manager.getActiveTab().getCurrentPage());
    }
}