public class Student extends AbstractUser {
    public Student(String name) {
        super(name, new StudentBorrowStrategy());
    }
    @Override
    public void showRole() {
        System.out.println(name + " is a Student.");
    }
}