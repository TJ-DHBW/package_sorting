package packageSortingCenter.centralControlUnit;

import base.Configuration;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import packageSortingCenter.centralControlUnit.events.general.ActivateRobotEvent;
import packageSortingCenter.centralControlUnit.events.general.LKWArrivedEvent;
import packageSortingCenter.centralControlUnit.events.general.SortStorageLanesEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.LKWUnloadedEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.StorageLaneFullEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.ZSEvent;
import packageSortingCenter.unloadingZone.ISensorUnloadingZoneListener;

import java.util.HashSet;

@SuppressWarnings("UnstableApiUsage")
public class CentralControlUnit implements ISensorUnloadingZoneListener {
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


    @Subscribe
    public void receive(LKWUnloadedEvent event){
        eventBus.post(new ActivateRobotEvent());
    }

    @Subscribe
    public void receive(StorageLaneFullEvent event){
        filledStorageLanes.add(event.getId());
        System.out.println("StorageLane " + event.getId() + " is now full.");
        if(filledStorageLanes.size() >= 8){
            System.out.println("All StorageLanes are full. Activate SortingLanes.");
            eventBus.post(new SortStorageLanesEvent());
            filledStorageLanes = new HashSet<>();
        }
    }
}
