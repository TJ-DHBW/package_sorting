package packageSortingCenter.permissions.encryption;

public interface IEncryptionStrategy {
    String encrypt(String message);

    String decrypt(String chiffre);
}
