public class SerializationAnnotation {
    public static void main(String[] args) {
        Account account = new Account("lakshya316", 22, "12345678");
        String json = Serializer.toJson(account);
        System.out.println(json);
    }
}