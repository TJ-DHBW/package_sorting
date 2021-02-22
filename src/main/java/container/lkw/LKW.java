package container.lkw;

public class LKW {
    /**
     * 4 chars from: [A-Z,0-9]
     */
    private String id;
    private LKWTrailer trailer;


    //region Getter and Setter

    public String getId() {
        return id;
    }

    public LKWTrailer getTrailer() {
        return trailer;
    }

    //endregion
}
