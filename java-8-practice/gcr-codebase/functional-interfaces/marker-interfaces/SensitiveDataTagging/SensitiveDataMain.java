public class SensitiveDataMain {
    public static void main(String[] args) {
        CustomerAccount account = new CustomerAccount("ACC123", "999-99-9999");
        ProductCatalog product = new ProductCatalog("Laptop");
        EncryptionService.encryptIfRequired(account);
        EncryptionService.encryptIfRequired(product);
    }
}