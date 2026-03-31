public class StudentBorrowStrategy implements BorrowStrategy {
    @Override
    public int getBorrowDays() {
        return 7;
    }
}