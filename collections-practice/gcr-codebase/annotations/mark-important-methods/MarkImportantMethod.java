import java.lang.reflect.Method;
public class MarkImportantMethod {
    public static void main(String[] args) {
        try {
            Class<TaskService> obj = TaskService.class;
            Method[] methods = obj.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(ImportantMethod.class)) {
                    ImportantMethod important = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Method: " + method.getName() + ", Level: " + important.level());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}