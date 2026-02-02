import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
public class DIContainer {
    private Map<Class<?>, Object> objects = new HashMap<>();
    public <T> T getBean(Class<T> clazz) throws Exception {
        if (!objects.containsKey(clazz)) {
            T instance = clazz.getDeclaredConstructor().newInstance();
            objects.put(clazz, instance);
            injectDependencies(instance);
        }
        return clazz.cast(objects.get(clazz));
    }
    private void injectDependencies(Object obj) throws Exception {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = getBean(fieldType);
                field.setAccessible(true);
                field.set(obj, dependency);
            }
        }
    }
}