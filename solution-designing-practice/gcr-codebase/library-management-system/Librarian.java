public class Librarian extends AbstractUser {
    public Librarian(String name) {
        super(name, () -> 0);
    }
    @Override
    public void showRole() {
        System.out.println(name + " is a Librarian.");
    }
}