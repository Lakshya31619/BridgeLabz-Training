import java.lang.reflect.Constructor;
public class DynamicallyCreateObjects {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Constructor<?> constructor = cls.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Lakshya", 22);
        Student student = (Student) obj;
        student.display();
    }
}