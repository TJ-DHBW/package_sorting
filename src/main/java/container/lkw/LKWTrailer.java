package container.lkw;

import container.Pallet;

public class LKWTrailer {
    /**
     * <ul><li>Has two sides: left, right</li><li>Can hold 5 Pallets per side.</li></ul>
     */
    private Pallet[][] pallets;

    public LKWTrailer() {
        pallets = new Pallet[2][5];
    }

    //region Getter and Setter
    public Pallet[][] getPallets() {
        return pallets;
    }

    public void setPallets(Pallet[][] pallets) {
        this.pallets = pallets;
    }

    //endregion
}
