package container.lkw;

import container.Pallet;

public class LKWTrailer {
    /**
     * <ul><li>Has two sides: left, right</li><li>Can hold 5 Pallets per side.</li></ul>
     */
    private Pallet[][] pallets;


    //region Getter and Setter
    public Pallet[][] getPallets() {
        return pallets;
    }
    //endregion
}
