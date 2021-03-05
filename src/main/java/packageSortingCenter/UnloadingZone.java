package packageSortingCenter;

import container.lkw.LKW;
import packageSortingCenter.unloadingZone.Sensor;

public class UnloadingZone {
    private LKW currentLKWUnloading;
    private Sensor sensor;

    public UnloadingZone() {
        sensor = new Sensor();
    }

//region  Getter and Setter

    public LKW getCurrentLKWUnloading() {
        return currentLKWUnloading;
    }

    public void setCurrentLKWUnloading(LKW currentLKWUnloading) {
        this.currentLKWUnloading = currentLKWUnloading;
    }


    //endregion
}
