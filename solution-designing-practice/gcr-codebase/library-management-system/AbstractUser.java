public abstract class AbstractUser implements User {
    protected String name;
    protected BorrowStrategy borrowStrategy;
    public AbstractUser(String name, BorrowStrategy strategy) {
        this.name = name;
        this.borrowStrategy = strategy;
    }
    @Override
    public int getBorrowDuration() {
        return borrowStrategy.getBorrowDays();
    }
    @Override
    public void update(String message) {
        System.out.println(name + " notified: " + message);
    }
}