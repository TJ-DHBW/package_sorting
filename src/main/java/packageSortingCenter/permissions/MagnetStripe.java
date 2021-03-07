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

    public char[] getActualContent() {
        for (int i = content.length - 1; i >= 0; i--) {
            if (content[i] != 0) {
                return Arrays.copyOfRange(content, 0, i + 1);
            }
        }
        return new char[0];
    }
}
