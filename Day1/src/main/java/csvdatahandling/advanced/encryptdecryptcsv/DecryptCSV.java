package csvdatahandling.advanced.encryptdecryptcsv;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.io.*;
import java.util.Base64;

public class DecryptCSV {
    private static SecretKey secretKey;

    public static void main(String[] args) {
        String encryptedFilePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\encryptdecryptcsv\\encryptedEmployees.csv";
        String keyFilePath = "C:\\Users\\Lenovol\\OneDrive\\Documents\\Desktop\\Week5\\Day1\\src\\main\\java\\csvdatahandling\\advanced\\encryptdecryptcsv\\secret.key"; // File to load the secret key

        try {
            // Load the secret key from the file
            try (ObjectInputStream keyInputStream = new ObjectInputStream(new FileInputStream(keyFilePath))) {
                secretKey = (SecretKey) keyInputStream.readObject();
            }

            // Decrypt the CSV file
            try (BufferedReader reader = new BufferedReader(new FileReader(encryptedFilePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] columns = line.split(",");
                    columns[3] = decrypt(columns[3]); // Decrypt Salary
                    columns[4] = decrypt(columns[4]); // Decrypt Email
                    System.out.println(String.join(",", columns));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedBytes);
    }
}
