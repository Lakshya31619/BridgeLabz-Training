import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
public class CustomLoggingProxy {
    public static void main(String[] args) {
        Greeting target = new GreetingService();
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class<?>[]{Greeting.class},
                new LoggingInvocationHandler(target)
        );
        proxy.sayHello();
    }
}