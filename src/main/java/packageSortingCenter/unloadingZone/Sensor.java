package packageSortingCenter.unloadingZone;

import java.util.ArrayList;

public class Sensor {
    private boolean activated = true;
    private ArrayList<ISensorUnloadingZoneListener> listenerList;
    private int zoneId;

    public Sensor(int zoneId) {
        this.zoneId = zoneId;
        listenerList = new ArrayList<>();
    }

    public void lkwDetected() {
        if (activated) {
            for (ISensorUnloadingZoneListener listeners : listenerList) {
                listeners.lkwArrived(zoneId);
            }
        } else {
            System.out.println("Sensor not activated");
        }
    }

    public void addListener(ISensorUnloadingZoneListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ISensorUnloadingZoneListener listener) {
        listenerList.remove(listener);
    }

    //region Getter and Setter

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }


    //endregion
}
