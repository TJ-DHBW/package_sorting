package packageSortingCenter;

import container.Pallet;

public class PalletIntermediateStorage {
    private Pallet[][] storedPallets;

    public PalletIntermediateStorage() {
        storedPallets = new Pallet[5][2];
    }

    public Pallet[][] getStoredPallets() {
        return storedPallets;
    }
}
