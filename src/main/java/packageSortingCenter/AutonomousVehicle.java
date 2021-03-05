package packageSortingCenter;

import container.Pallet;

public class AutonomousVehicle {
    private Pallet currentPalletTransported;

    //region Getter and Setter

    public Pallet getCurrentPalletTransported() {
        return currentPalletTransported;
    }

    public void setCurrentPalletTransported(Pallet currentPalletTransported) {
        this.currentPalletTransported = currentPalletTransported;
    }


    //endregion

}
