public class EncryptionService {
    public static void encryptIfRequired(Object obj) {
        if (obj instanceof SensitiveData) {
            System.out.println("Encrypting sensitive data for: " + obj.getClass().getSimpleName());
        } else {
            System.out.println("No encryption required for: " + obj.getClass().getSimpleName());
        }
    }
}