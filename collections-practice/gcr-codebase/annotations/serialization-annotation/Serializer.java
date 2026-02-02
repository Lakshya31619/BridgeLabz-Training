import java.lang.reflect.Field;
public class Serializer {
    public static String toJson(Object obj) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        boolean first = true;
        try {
            for (Field field : fields) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    JsonField annotation = field.getAnnotation(JsonField.class);
                    if (!first) {
                        json.append(", ");
                    }
                    String key = annotation.name();
                    Object value = field.get(obj);
                    json.append("\"").append(key).append("\": ");
                    if (value instanceof String) {
                        json.append("\"").append(value).append("\"");
                    } else {
                        json.append(value);
                    }
                    first = false;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        json.append("}");
        return json.toString();
    }
}