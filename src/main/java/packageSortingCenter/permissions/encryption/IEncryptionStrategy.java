package packageSortingCenter.permissions.encryption;

//Other encryption strategies could be easily implemented -> open closed principle
public interface IEncryptionStrategy {
    String encrypt(String message);

    String decrypt(String chiffre);
}
