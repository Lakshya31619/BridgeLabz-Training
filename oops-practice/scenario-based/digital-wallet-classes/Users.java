public class Users {
private int userId;
    private String name;
    private Wallet wallet;
    public Users(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet();
    }
    public String getName() {
        return name;
    }
    public Wallet getWallet() {
        return wallet;
    }
}