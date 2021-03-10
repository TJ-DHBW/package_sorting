package base;

import packageSortingCenter.permissions.encryption.DES;
import packageSortingCenter.permissions.encryption.IEncryptionStrategy;

import java.util.Random;

public enum Configuration {
    instance;

    // i/o
    public final String fileSeparator = System.getProperty("file.separator");
    public final String userDirectory = System.getProperty("user.dir");
    public final String exportDirectory = userDirectory + fileSeparator + "export" + fileSeparator;
    //encryption
    public final String secret = "thisIsTheSecretKey";
    public final IEncryptionStrategy encryptionStrategy = new DES(secret);
    //implementation
    public Integer[] packageIndexToHide = {3, 57, 100, 200};
    public Integer numberOfLkw = 5;
    public Integer numberOfPallets = numberOfLkw * 10;
    public Integer numberOfBoxes = numberOfPallets * 12;
    public Integer numberOfPackages = numberOfBoxes * 40;
    //random
    public Random randomGenerator = new Random();
    //Components
    public String componentsFolder = "components";
    public String libraryPath = "build" + fileSeparator + "libs";
}
