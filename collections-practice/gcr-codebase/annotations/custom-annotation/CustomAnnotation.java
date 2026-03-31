import java.lang.reflect.Method;
public class CustomAnnotation {
    public static void main(String[] args) {
        try {
            Class<TaskManager> obj = TaskManager.class;
            Method[] methods = obj.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(TaskInfo.class)) {
                    TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                    System.out.println("Method: " + method.getName());
                    System.out.println("Priority: " + taskInfo.priority());
                    System.out.println("Assigned To: " + taskInfo.assignedTo());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}