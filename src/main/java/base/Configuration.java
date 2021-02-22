package base;

import java.util.Random;

public enum Configuration {
    instance;

    // i/o
    public final String fileSeparator = System.getProperty("file.separator");
    public final String userDirectory = System.getProperty("user.dir");
    public final String lineSeparator = System.getProperty("line.separator");
    public final String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
    public final String exportDirectory = userDirectory + fileSeparator + "export" + fileSeparator;

    //random
    public Random randomGenerator = new Random();
}
