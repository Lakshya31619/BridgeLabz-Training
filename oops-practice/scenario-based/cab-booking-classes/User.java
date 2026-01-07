//User class
class User{
    private int userID;
    private String name;
    public User(int userID, String name){
        this.userID = userID;
        this.name = name;
    }
    public String getName(){
        return name;
    }
}