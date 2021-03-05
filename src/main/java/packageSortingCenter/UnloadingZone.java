package packageSortingCenter;

import container.lkw.LKW;
import packageSortingCenter.unloadingZone.Sensor;

public class UnloadingZone {
    private LKW currentLKWUnloading;
    private Sensor sensor;
    private int id;
    private static int nextId = 0;

    public UnloadingZone() {
        this.id = nextId++;
        sensor = new Sensor(id);
    }

    //region  Getter and Setter
    public LKW getCurrentLKWUnloading() {
        return currentLKWUnloading;
    }

    public void setCurrentLKWUnloading(LKW currentLKWUnloading) {
        this.currentLKWUnloading = currentLKWUnloading;
        sensor.lkwDetected();
    }

    public int getId() {
        return id;
    }

    //endregion
}
