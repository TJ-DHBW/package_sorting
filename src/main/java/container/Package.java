package container;

import unordered.PacketType;

public class Package {
    /**
     * Consists of chars of the type: [a-z, 0-9]
     */
    private String id;
    /**
     * (L: 25, B: 10, H: 10), CharPool: [a-z | .| : | - | !],
     */
    private char[][][] content;
    /**
     * Within: [01067-99998]]
     */
    private String zipCode;
    private PacketType type;
    /**
     * Within: [1.00 bis 5.00]
     */
    private float weight;   //TODO oder double?

    //region Getter and Setter
    public String getId() {
        return id;
    }

    public char[][][] getContent() {
        return content;
    }

    public String getZipCode() {
        return zipCode;
    }

    public PacketType getType() {
        return type;
    }

    public float getWeight() {
        return weight;
    }
    //endregion
}
