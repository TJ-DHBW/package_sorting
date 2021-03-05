package packageSortingCenter.sortingFacility;

import container.Box;
import container.Package;

public class StorageLane {
    private final Package[] lane;
    private final Sensor sensor;
    private int id;
    private static int nextId = 0;

    public StorageLane(int size) {
        this.id = nextId++;
        this.lane = new Package[size];
        this.sensor = new Sensor(id);
    }
    public boolean put(Package packageToAdd) {
        for (int i = 0; i < lane.length; i++) {
            if (lane[i] == null) {
                lane[i] = packageToAdd;
                return true;
            }

            if (i == lane.length - 1) {
                sensor.storageLaneIsFilled();
            }
        }
        return false;
    }

    public Sensor getSensor() {
        return sensor;
    }
}
