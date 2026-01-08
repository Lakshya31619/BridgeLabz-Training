class TextState {
    String content;
    TextState prev;
    TextState next;
    TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
public class TextEditorUndoRedo {
    private static final int MAX_HISTORY = 10;
    private static TextState head = null;
    private static TextState tail = null;
    private static TextState current = null;
    private static int size = 0;
    //Add new text state
    public static void addState(String text) {
        TextState newState = new TextState(text);
        //If undo was used remove redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = calculateSize();
        }
        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }
        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    //Undo
    public static void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("Undo not possible.");
        }
    }
    //Redo
    public static void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("Redo not possible.");
        }
    }
    //Display Current State
    public static void displayCurrentState() {
        if (current != null)
            System.out.println("Current Text: \"" + current.content + "\"");
        else
            System.out.println("Editor is empty.");
    }
    //Display Full History
    public static void displayHistory() {
        System.out.println("\nText History:");
        TextState temp = head;
        while (temp != null) {
            if (temp == current)
                System.out.println("-> " + temp.content + " (current)");
            else
                System.out.println("   " + temp.content);
            temp = temp.next;
        }
    }
    //Helper
    private static int calculateSize() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    //Main Method
    public static void main(String[] args) {
        addState("Hello");
        addState("Hello World");
        addState("Hello World!");
        addState("Hello World! This");
        addState("Hello World! This is");
        addState("Hello World! This is a");
        addState("Hello World! This is a Text");
        addState("Hello World! This is a Text Editor");
        displayCurrentState();
        displayHistory();
        System.out.println("\nUndo operations:");
        undo();
        displayCurrentState();
        undo();
        displayCurrentState();
        System.out.println("\nRedo operations:");
        redo();
        displayCurrentState();
        System.out.println("\nAdding new text after undo (redo history cleared):");
        addState("Hello World! New Content");
        displayCurrentState();
        displayHistory();
    }
}