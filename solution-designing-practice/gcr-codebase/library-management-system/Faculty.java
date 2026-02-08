public class Faculty extends AbstractUser {
    public Faculty(String name) {
        super(name, new FacultyBorrowStrategy());
    }
    @Override
    public void showRole() {
        System.out.println(name + " is a Faculty.");
    }
}