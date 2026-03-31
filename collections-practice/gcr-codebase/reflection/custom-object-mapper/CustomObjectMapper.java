import java.util.HashMap;
import java.util.Map;
public class CustomObjectMapper {
    public static void main(String[] args) throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("username", "lakshya_v");
        data.put("age", 22);
        User user = ObjectMapper.toObject(User.class, data);
        System.out.println(user);
    }
}