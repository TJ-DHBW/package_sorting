package packageSortingCenter.permissions;

import base.Configuration;

import java.util.Arrays;

public class MagnetStripe {
    private final char[] content;

    public MagnetStripe(String content) {
        String encryptedContent = Configuration.instance.encryptionStrategy.encrypt(content);

        this.content = Arrays.copyOfRange(encryptedContent.toCharArray(), 0, 100);
    }

    public char[] getContent() {
        return content;
    }
}
