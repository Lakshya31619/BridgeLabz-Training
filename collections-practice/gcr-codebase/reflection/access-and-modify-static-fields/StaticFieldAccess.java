import java.lang.reflect.Field;
public class StaticFieldAccess {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Configuration.class;
        Field field = cls.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null, "NEW_SECRET_KEY");
        String value = (String) field.get(null);
        System.out.println("API_KEY = " + value);
    }
}