package packageSortingCenter.centralControlUnit;

import base.Configuration;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import packageSortingCenter.centralControlUnit.events.general.LKWArrivedEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.LKWUnloadedEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.StorageLaneFullEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.ZSEvent;
import packageSortingCenter.sortingFacility.ISensorStorageLaneListener;
import packageSortingCenter.unloadingZone.ISensorUnloadingZoneListener;

import java.util.HashSet;

@SuppressWarnings("UnstableApiUsage")
public class CentralControlUnit implements ISensorUnloadingZoneListener, ISensorStorageLaneListener {
    private final EventBus eventBus;
    private final int numberOfVehicles;

    private HashSet<Integer> filledStorageLanes;

    public CentralControlUnit(int numberOfVehicles) {
        eventBus = new EventBus("PackageSortingCenterEventBus");
        this.numberOfVehicles = numberOfVehicles;
        this.filledStorageLanes = new HashSet<>();
        subscribe(this);
    }

    public void subscribe(Object o){
        eventBus.register(o);
    }

    public void unsubscribe(Object o){
        eventBus.unregister(o);
    }

    public void notifyEventbus(ZSEvent event){
        eventBus.post(event);
    }


    @Override
    public void lkwArrived(int zoneId) {
        eventBus.post(new LKWArrivedEvent(zoneId, Configuration.instance.randomGenerator.nextInt(numberOfVehicles)));
    }

    @Override
    public void storageLaneFilled(int id) {
        eventBus.post(new StorageLaneFullEvent());
        int sizeBefore = filledStorageLanes.size();
        filledStorageLanes.add(id);
        if(sizeBefore == filledStorageLanes.size()){
            System.out.println("Storagelane "+id+" was already filled!");
        }
        if(filledStorageLanes.size() == 7){
            eventBus.post(new StorageLaneFullEvent());
        }
        System.out.println("CCU has been informed, that storageLane is filled");
    }

    @Subscribe
    public void receive(LKWUnloadedEvent event){
        //TODO
    }
    @Subscribe
    public void receive(StorageLaneFullEvent event){
        //TODO
    }

    //TODO Check if nothing was forgotten.
}
