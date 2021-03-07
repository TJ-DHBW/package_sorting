package container;

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
    private PackageType type;
    /**
     * Within: [1.00 bis 5.00]
     */
    private float weight;

    //region Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public char[][][] getContent() {
        return content;
    }

    public void setContent(char[][][] content) {
        this.content = content;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public PackageType getType() {
        return type;
    }

    public void setType(PackageType type) {
        this.type = type;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    //endregion
}
