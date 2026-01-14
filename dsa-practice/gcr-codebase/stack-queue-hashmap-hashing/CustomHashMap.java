import java.util.Scanner;
public class CustomHashMap {
    static class Node {
        int key;
        int value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    static class MyHashMap {
        private final int SIZE = 16;
        private Node[] buckets = new Node[SIZE];
        private int hash(int key) {
            return key % SIZE;
        }
        //Put
        public void put(int key, int value) {
            int index = hash(key);
            Node curr = buckets[index];
            while (curr != null) {
                if (curr.key == key) {
                    curr.value = value;
                    return;
                }
                curr = curr.next;
            }
            Node newNode = new Node(key, value);
            newNode.next = buckets[index];
            buckets[index] = newNode;
        }
        //Get
        public int get(int key) {
            int index = hash(key);
            Node curr = buckets[index];
            while (curr != null) {
                if (curr.key == key) {
                    return curr.value;
                }
                curr = curr.next;
            }
            return -1;
        }
        //Remove
        public void remove(int key) {
            int index = hash(key);
            Node curr = buckets[index];
            Node prev = null;
            while (curr != null) {
                if (curr.key == key) {
                    if (prev == null) {
                        buckets[index] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyHashMap map = new MyHashMap();
        System.out.print("Enter key to insert: ");
        int key = sc.nextInt();
        System.out.print("Enter value: ");
        int value = sc.nextInt();
        map.put(key, value);
        System.out.print("Enter key to retrieve: ");
        int searchKey = sc.nextInt();
        int result = map.get(searchKey);
        System.out.println("Value: " + result);
        System.out.print("Enter key to remove: ");
        int removeKey = sc.nextInt();
        map.remove(removeKey);
        System.out.println("Key removed");
    }
}