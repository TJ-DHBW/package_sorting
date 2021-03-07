package base;

import packageSortingCenter.permissions.encryption.DES;
import packageSortingCenter.permissions.encryption.IEncryptionStrategy;

import java.util.Random;

public enum Configuration {
    instance;

    // i/o
    public final String fileSeparator = System.getProperty("file.separator");
    public final String userDirectory = System.getProperty("user.dir");
    public final String lineSeparator = System.getProperty("line.separator");
    public final String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
    public final String exportDirectory = userDirectory + fileSeparator + "export" + fileSeparator;

    //implementation
    public Integer[] packageIndexToHide = {3,57,100,200};
    public Integer numberOfLkw = 1;
    public Integer numberOfPallets = numberOfLkw * 10;
    public Integer numberOfBoxes = numberOfPallets * 12;
    public Integer numberOfPackages = numberOfBoxes * 40;

    //random
    public Random randomGenerator = new Random();

    //encryption
    public final String secret = "thisIsTheSecretKey";
    public final IEncryptionStrategy encryptionStrategy = new DES(secret);

    //Components
    public String componentsFolder = "components";
    public String libraryPath = "build" + fileSeparator + "libs";
}
