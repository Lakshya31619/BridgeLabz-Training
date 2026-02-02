import java.lang.reflect.*;
import java.util.Scanner;
public class GetClassInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter class name (example: java.lang.String): ");
        String className = sc.nextLine();
        try {
            Class<?> cls = Class.forName(className);
            System.out.println("Class Name: " + cls.getName());
            System.out.println("Constructors : ");
            Constructor<?>[] constructors = cls.getConstructors();
            for (Constructor<?> c : constructors) {
                System.out.println(c);
            }
            System.out.println("Fields : ");
            Field[] fields = cls.getFields();
            for (Field f : fields) {
                System.out.println(f);
            }
            System.out.println("Methods : ");
            Method[] methods = cls.getMethods();
            for (Method m : methods) {
                System.out.println(m);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }
    }
}