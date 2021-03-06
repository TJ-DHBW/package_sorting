package container;

public class Box {
    /**
     * 5 chars from: [a-z, 0-9]
     */
    private String id;
    /**
     * <ul><li>There are 5 Layers.</li><li>Each Layer has two sides: left, right.</li><li>Each side has 4 Packets.</li></ul>
     */
    private Package[][][] packages;

    public Box() {
        packages = new Package[5][2][4];
    }

    //region Getter and Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Package[][][] getPackages() {
        return packages;
    }

    public void setPackages(Package[][][] packages) {
        this.packages = packages;
    }


    //endregion
}
