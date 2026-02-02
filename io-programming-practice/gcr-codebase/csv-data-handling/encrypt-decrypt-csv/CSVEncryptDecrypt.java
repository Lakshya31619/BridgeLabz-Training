import java.io.*;
import java.util.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class CSVEncryptDecrypt {
    private static SecretKey secretKey;
    public static void main(String[] args) throws Exception {
        secretKey = generateKey();
        String inputCsv = "./io-programming-practice/gcr-codebase/csv-data-handling/encrypt-decrypt-csv/employees.csv";
        String encryptedCsv = "./io-programming-practice/gcr-codebase/csv-data-handling/encrypt-decrypt-csv/employees_encrypted.csv";
        String decryptedCsv = "./io-programming-practice/gcr-codebase/csv-data-handling/encrypt-decrypt-csv/employees_decrypted.csv";
        encryptCSV(inputCsv, encryptedCsv);
        decryptCSV(encryptedCsv, decryptedCsv);
    }
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }
    private static String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] enc = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(enc);
    }
    private static String decrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] dec = Base64.getDecoder().decode(data);
        return new String(cipher.doFinal(dec));
    }
    private static void encryptCSV(String inputCsv, String outputCsv) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputCsv));
             FileWriter writer = new FileWriter(outputCsv)) {
            String header = br.readLine();
            writer.append(header).append("\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String email = encrypt(parts[1]);
                String salary = encrypt(parts[3]);
                writer.append(parts[0]).append(",")
                        .append(email).append(",")
                        .append(parts[2]).append(",")
                        .append(salary).append("\n");
            }
            System.out.println("CSV encrypted successfully: " + outputCsv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void decryptCSV(String encryptedCsv, String outputCsv) {
        try (BufferedReader br = new BufferedReader(new FileReader(encryptedCsv));
             FileWriter writer = new FileWriter(outputCsv)) {
            String header = br.readLine();
            writer.append(header).append("\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String email = decrypt(parts[1]);
                String salary = decrypt(parts[3]);
                writer.append(parts[0]).append(",")
                        .append(email).append(",")
                        .append(parts[2]).append(",")
                        .append(salary).append("\n");
            }
            System.out.println("CSV decrypted successfully: " + outputCsv);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}