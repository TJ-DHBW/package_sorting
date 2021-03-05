package packageSortingCenter.sortingFacility;

import java.util.ArrayList;

public class Sensor {
    private ArrayList<ISensorStorageLaneListener> listenerList;
    private int storageLaneId;

    public Sensor(int storageLaneId) {
        this.storageLaneId = storageLaneId;
    }

    public void storageLaneIsFilled(){
        for (ISensorStorageLaneListener listener : listenerList) {
            listener.storageLaneFilled(storageLaneId);
        }
    }
    public void addListener(ISensorStorageLaneListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ISensorStorageLaneListener listener) {
        listenerList.remove(listener);
    }
}
