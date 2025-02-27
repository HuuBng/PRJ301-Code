package hashing;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

    public static String hash(String password) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPassword) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("1"));
        System.out.println(hash("123"));
        System.out.println(hash("1").length());
    }
    
}
