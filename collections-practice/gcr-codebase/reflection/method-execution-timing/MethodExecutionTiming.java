import java.lang.reflect.Proxy;
public class MethodExecutionTiming {
    public static void main(String[] args) {
        TaskService target = new TaskServiceImpl();
        TaskService proxy = (TaskService) Proxy.newProxyInstance(
                TaskService.class.getClassLoader(),
                new Class<?>[]{TaskService.class},
                new TimingInvocationHandler(target)
        );
        proxy.fastTask();
        proxy.slowTask();
    }
}