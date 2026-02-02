import java.lang.reflect.Field;
public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Class<?> cls = p.getClass();
        Field field = cls.getDeclaredField("age");
        field.setAccessible(true);
        field.set(p, 30);
        int value = (int) field.get(p);
        System.out.println("Age = " + value);
    }
}