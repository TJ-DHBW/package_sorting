package packageSortingCenter.unloadingZone;

import java.util.ArrayList;

public class Sensor {
    private boolean activated;
    private ArrayList<ISensorListener> listenerList;

    public Sensor(){
        listenerList = new ArrayList<>();
    }

    public void lkwDetected(){
        if(activated) {
            for (ISensorListener listeners : listenerList) {
                listeners.lkwArrived();
            }
        }
        else{
            System.out.println("Sensor not activated");
        }
    }

    public void addListener(ISensorListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ISensorListener listener) {
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
