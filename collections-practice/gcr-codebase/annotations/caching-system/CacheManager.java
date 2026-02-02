import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
public class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();
    public static Object execute(Object service, String methodName, Object... args) {
        try {
            Class<?> cls = service.getClass();
            Class<?>[] paramTypes = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                paramTypes[i] = getPrimitiveType(args[i].getClass());
            }
            Method method = cls.getMethod(methodName, paramTypes);
            if (method.isAnnotationPresent(CacheResult.class)) {
                String key = buildCacheKey(cls.getName(), methodName, args);
                if (cache.containsKey(key)) {
                    System.out.println("Returning cached result...");
                    return cache.get(key);
                }
                Object result = method.invoke(service, args);
                cache.put(key, result);
                return result;
            }
            return method.invoke(service, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static Class<?> getPrimitiveType(Class<?> cls) {
        if (cls == Integer.class) return int.class;
        if (cls == Double.class) return double.class;
        if (cls == Boolean.class) return boolean.class;
        if (cls == Long.class) return long.class;
        if (cls == Float.class) return float.class;
        if (cls == Short.class) return short.class;
        if (cls == Byte.class) return byte.class;
        if (cls == Character.class) return char.class;
        return cls;
    }
    private static String buildCacheKey(String className, String methodName, Object[] args) {
        StringBuilder key = new StringBuilder(className)
                .append(".")
                .append(methodName);
        for (Object arg : args) {
            key.append("_").append(arg);
        }
        return key.toString();
    }
}