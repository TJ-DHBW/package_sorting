package packageSortingCenter.sortingFacility;

import container.Package;

import java.util.ArrayList;

public class StorageLane {
    private final Package[] lane;

    private final Sensor sensor;
    private final ArrayList<IStorageLaneListener> listenerList;
    private final int id;
    private static int nextId = 0;

    public StorageLane(int size) {
        this.id = nextId++;
        this.lane = new Package[size];
        this.sensor = new Sensor();
        this.listenerList = new ArrayList<>();

        addListener(sensor);
    }
    public boolean put(Package packageToAdd) {
        for (int i = 0; i < lane.length; i++) {
            if (lane[i] == null) {
                lane[i] = packageToAdd;

                if (i == lane.length - 1) {
                    notifyListeners();
                }

                return true;
            }
        }
        return false;
    }

    public Package pull(){
        for(int i = 0; i < lane.length; i++){
            if(lane[i] != null){
                Package tmp = lane[i];
                lane[i] = null;
                return tmp;
            }
        }

        return null;
    }

    public void addListener(IStorageLaneListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(IStorageLaneListener listener) {
        listenerList.remove(listener);
    }

    private void notifyListeners(){
        for(IStorageLaneListener listener : listenerList){
            listener.storageLaneFilled(id);
        }
    }

    public Sensor getSensor() {
        return sensor;
    }
}
