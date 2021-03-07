package packageSortingCenter.sortingFacility;

import packageSortingCenter.centralControlUnit.CentralControlUnit;
import packageSortingCenter.centralControlUnit.events.zsEvents.StorageLaneFullEvent;

public class Sensor implements IStorageLaneListener {
    private CentralControlUnit centralControlUnit;

    @Override
    public void storageLaneFilled(int id) {
        centralControlUnit.notifyEventbus(new StorageLaneFullEvent(id));
    }

    public void connectToCentralControlUnit(CentralControlUnit centralControlUnit) {
        this.centralControlUnit = centralControlUnit;
    }
}
