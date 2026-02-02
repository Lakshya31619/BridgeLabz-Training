import java.lang.reflect.Method;
public class RepeatableAnnotation {
    public static void main(String[] args) {
        try {
            Class<BugManager> obj = BugManager.class;
            Method[] methods = obj.getDeclaredMethods();
            for (Method method : methods) {
                BugReport[] bugs = method.getAnnotationsByType(BugReport.class);
                if (bugs.length > 0) {
                    System.out.println("Method: " + method.getName());
                    for (BugReport bug : bugs) {
                        System.out.println("Bug Description: " + bug.description());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}