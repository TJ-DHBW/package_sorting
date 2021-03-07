package packageSortingCenter;

import container.lkw.LKW;
import packageSortingCenter.unloadingZone.Sensor;

public class UnloadingZone {
    private static int nextId = 0;
    private LKW currentLKWUnloading;
    private Sensor sensor;
    private int id;

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
        if (currentLKWUnloading != null) {
            sensor.lkwDetected();
        }
    }

    public int getId() {
        return id;
    }

    public Sensor getSensor() {
        return sensor;
    }

    //endregion
}
