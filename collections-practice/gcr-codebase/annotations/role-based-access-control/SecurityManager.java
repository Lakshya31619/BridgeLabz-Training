import java.lang.reflect.Method;
public class SecurityManager {
    public static void execute(Object service, String currentUserRole) {
        Class<?> cls = service.getClass();
        if (cls.isAnnotationPresent(RoleAllowed.class)) {
            RoleAllowed roleAllowed = cls.getAnnotation(RoleAllowed.class);
            String requiredRole = roleAllowed.value();

            if (!requiredRole.equals(currentUserRole)) {
                System.out.println("Access Denied!");
                return;
            }
        }
        Method[] methods = cls.getDeclaredMethods();
        try {
            for (Method method : methods) {
                method.invoke(service);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}