public class FacultyBorrowStrategy implements BorrowStrategy {
    @Override
    public int getBorrowDays() {
        return 30;
    }
}