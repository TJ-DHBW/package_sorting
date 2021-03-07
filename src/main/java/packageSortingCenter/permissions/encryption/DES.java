package packageSortingCenter.permissions.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

//Taken from userid#4701
//Different Classes for DES and AES -> Single-Responsibility
public class DES implements IEncryptionStrategy {
    private SecretKeySpec secretKey;

    public DES(String secret) {
        setKey(secret);
    }

    public void setKey(String myKey) {
        try {
            var key = myKey.getBytes(StandardCharsets.UTF_8);

            var sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 24);

            secretKey = new SecretKeySpec(key, "DESede");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String encrypt(String strToEncrypt) {
        try {
            var cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            var buffer = cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(buffer);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}