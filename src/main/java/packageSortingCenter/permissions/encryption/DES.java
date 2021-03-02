package packageSortingCenter.permissions.encryption;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

// Modified from: https://laptrinhx.com/implementation-of-des-encryption-algorithms-in-java-513453941/

public class DES implements IEncryptionStrategy {

    private static final String ENCODEING = "UTF-8";
    private static final String ALGORITHM = "DES";//encryption algorithm

    private SecretKey secureKey;

    // Length of secret should not be less than 8.
    public DES(String secret) {
        try {
            DESKeySpec desKey = new DESKeySpec(secret.getBytes(ENCODEING));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            secureKey = keyFactory.generateSecret(desKey);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }

    /**
     *  DES Algorithmic encryption
     * @param plaintext Text to be encrypted
     * @Author Ron
     * @Date 2017 September 12, 11:54:12 a.m.
     * @return Encrypted String
     */
    @Override
    public String encrypt(String plaintext) {
        String encryptStr = "";
        try {
            byte[] datasource = plaintext.getBytes(ENCODEING);
            SecureRandom random = new SecureRandom();

            //Cipher Object Actually Completes Encryption Operation
            Cipher cipher = Cipher.getInstance(ALGORITHM);

            //Initialization of Cipher objects with keys
            cipher.init(Cipher.ENCRYPT_MODE, secureKey, random);

            //Now, get the data and encrypt it
            //Formal Encryption Operation
            byte[] encryptSrc = cipher.doFinal(datasource);

            encryptStr = Base64.getEncoder().encodeToString(encryptSrc);
        } catch (Exception e) {
            System.out.println("DES Encryption report exception");
        }
        return encryptStr;
    }

    /**
     *  Decrypt
     * @param encryptStr Encrypted string
     * @Author Ron
     * @Date 2017 September 12, 1:12:56 p.m.
     * @return Decrypted String
     */
    public String decrypt(String encryptStr){
        String decryptStr = "";
        try {
            byte[] src = Base64.getDecoder().decode(encryptStr);
            // DES algorithm requires a trusted random number source
            SecureRandom random = new SecureRandom();

            // Cipher object actually completes decryption operation
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            // Initialization of Cipher objects with keys
            cipher.init(Cipher.DECRYPT_MODE, secureKey, random);
            // Really start decryption
            byte[] decryptSrc = cipher.doFinal(src);
            decryptStr = new String(decryptSrc,ENCODEING);
        } catch (Exception e) {
            System.out.println("DES Decryption failed");
        }
        return decryptStr;
    }
}
