package packageSortingCenter.centralControlUnit;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import packageSortingCenter.centralControlUnit.events.zsEvents.LKWArrivedEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.LKWUnloadedEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.StorageTrackFullEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.ZSEvent;

@SuppressWarnings("UnstableApiUsage")
public class CentralControlUnit {
    private final EventBus eventBus;

    //TODO should the constructor be public?
    public CentralControlUnit() {
        eventBus = new EventBus("PackageSortingCenterEventBus");

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
        //TODO do I really want to do it this way?
    }

    public void init(){
        //TODO
    }
    public void next(){
        //TODO
    }
    public void shutdown(){
        //TODO
    }
    public void lock(){
        //TODO
    }
    public void unlock(){
        //TODO
    }
    public void showStatistics(){
        //TODO
    }
    public void changeSearchAlgorithm(){
        //TODO
    }

    @Subscribe
    public void receive(LKWArrivedEvent event){
        //TODO
    }
    @Subscribe
    public void receive(LKWUnloadedEvent event){
        //TODO
    }
    @Subscribe
    public void receive(StorageTrackFullEvent event){
        //TODO
    }

    //TODO Check if nothing was forgotten.
}
