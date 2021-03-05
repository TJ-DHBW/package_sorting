package packageSortingCenter;

import container.lkw.LKW;

import java.util.ArrayList;

public class LkwWaitingArea {
    private LKW[] lkws;

    public LkwWaitingArea() {
        lkws = new LKW[5];
    }

    //region Getter and Setter

    public LKW[] getLkws() {
        return lkws;
    }

    public void setLkws(LKW[] lkws) {
        this.lkws = lkws;
    }
    //endregion
}
