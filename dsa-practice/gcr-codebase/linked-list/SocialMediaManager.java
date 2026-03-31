//Friendsn List Node
class FriendNode {
    int friendId;
    FriendNode next;
    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}
//User Node
class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends; 
    UserNode next;
    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }
}
public class SocialMediaManager {
    private static UserNode head = null;
    //Add User
    public static void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }
    //Find user by ID
    private static UserNode findUserById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }
    //Add Friend
    public static void addFriendConnection(int id1, int id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }
        addFriend(user1, id2);
        addFriend(user2, id1);
    }
    private static void addFriend(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friends;
        user.friends = newFriend;
    }
    //Remove friend
    public static void removeFriendConnection(int id1, int id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }
        removeFriend(user1, id2);
        removeFriend(user2, id1);
    }
    private static void removeFriend(UserNode user, int friendId) {
        FriendNode curr = user.friends;
        FriendNode prev = null;
        while (curr != null && curr.friendId != friendId) {
            prev = curr;
            curr = curr.next;
        }
        if (curr == null) return;
        if (prev == null)
            user.friends = curr.next;
        else
            prev.next = curr.next;
    }
    //Display friends of a user
    public static void displayFriends(int userId) {
        UserNode user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        System.out.println("\nFriends of " + user.name + ":");
        FriendNode temp = user.friends;
        if (temp == null) {
            System.out.println("No friends.");
            return;
        }
        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendId);
            temp = temp.next;
        }
    }
    //Find mutual friends
    public static void findMutualFriends(int id1, int id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found!");
            return;
        }
        System.out.println("\nMutual Friends of " + user1.name + " and " + user2.name + ":");
        FriendNode f1 = user1.friends;
        boolean found = false;
        while (f1 != null) {
            FriendNode f2 = user2.friends;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    System.out.println("Friend ID: " + f1.friendId);
                    found = true;
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }
        if (!found)
            System.out.println("No mutual friends.");
    }
    //Search user
    public static void searchUserById(int id) {
        UserNode user = findUserById(id);
        if (user != null)
            displayUser(user);
        else
            System.out.println("User not found!");
    }
    public static void searchUserByName(String name) {
        UserNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayUser(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("User not found!");
    }
    //Count Friends for each user
    public static void countFriendsForEachUser() {
        UserNode temp = head;
        System.out.println("\nFriend Count:");
        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friends;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends.");
            temp = temp.next;
        }
    }
    //Display
    private static void displayUser(UserNode u) {
        System.out.println("ID: " + u.userId + ", Name: " + u.name + ", Age: " + u.age);
    }
    //Main class
    public static void main(String[] args) {
        addUser(1, "Angraaj Karn", 21);
        addUser(2, "Brahman Risky Pandit", 22);
        addUser(3, "Charlie Kirk", 23);
        addUser(4, "David Putra", 24);
        addFriendConnection(1, 2);
        addFriendConnection(1, 3);
        addFriendConnection(2, 3);
        addFriendConnection(3, 4);
        displayFriends(1);
        displayFriends(3);
        findMutualFriends(1, 2);
        System.out.println("\nSearch by ID:");
        searchUserById(3);
        System.out.println("\nSearch by Name:");
        searchUserByName("David");
        System.out.println("\nRemoving friend connection between 1 and 3");
        removeFriendConnection(1, 3);
        displayFriends(1);
        countFriendsForEachUser();
    }
}