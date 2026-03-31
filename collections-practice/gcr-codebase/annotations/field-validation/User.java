import java.lang.reflect.Field;
public class User {
    @MaxLength(10)
    private String username;
    public User(String username) {
        validate(username);
        this.username = username;
    }
    private void validate(String username) {
        try {
            Field field = this.getClass().getDeclaredField("username");
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (username.length() > maxLength.value()) {
                    throw new IllegalArgumentException(
                        "Username exceeds maximum length of " + maxLength.value()
                    );
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public String getUsername() {
        return username;
    }
}