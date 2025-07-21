package com.filesencryptiondecryptiondemo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;

public class FileEncryptor {

    private static final String SECRET_KEY = "mySuperSecret123";

    public static void main(String[] args) throws Exception {

        boolean encryptMode = true;

        File file = new File("FileHandling/src/com/filesencryptiondecryptiondemo/DEMO123_TXN_20250715.csv");

        byte[] fileBytes = Files.readAllBytes(file.toPath());

        byte[] resultBytes;

        if (encryptMode) {
            resultBytes = encrypt(fileBytes, SECRET_KEY);
            System.out.println(" File encrypted successfully.");
        } else {
            resultBytes = decrypt(fileBytes, SECRET_KEY);
            System.out.println(" File decrypted successfully.");
        }


        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(resultBytes);
        }
    }

    public static byte[] encrypt(byte[] data, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, String key) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(data);
    }
}
