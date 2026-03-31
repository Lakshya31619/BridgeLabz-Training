public class JsonRepresentation {
    public static void main(String[] args) throws Exception {
        Account account = new Account("ACC12345", 1500.75);
        String json = JsonSerializer.toJson(account);
        System.out.println(json);
    }
}