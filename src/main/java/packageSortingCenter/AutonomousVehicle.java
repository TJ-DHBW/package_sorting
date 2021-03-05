package packageSortingCenter;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import container.Pallet;
import container.lkw.LKW;
import packageSortingCenter.centralControlUnit.events.general.LKWArrivedEvent;
import packageSortingCenter.centralControlUnit.events.zsEvents.LKWUnloadedEvent;
import packageSortingCenter.sortingFacility.StoragePlace;
public class AutonomousVehicle {
    PackageSortingCenter packageSortingCenter;
    private int id;
    private static int nextId = 0;
    private ParkingSpot parkingSpot;


    public AutonomousVehicle(PackageSortingCenter packageSortingCenter, ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
        this.packageSortingCenter = packageSortingCenter;
        this.id = nextId++;
    }

    public void unloadLKW(int unloadingZoneId) {
        parkingSpot.setParkedVehicle(null);
        System.out.println("Vehicle "+id+" has left parking spot");
        for (UnloadingZone unloadingZone : packageSortingCenter.getUnloadingZones()) {
            if (unloadingZone.getId() == unloadingZoneId) {
                for (int sideCounter = 0; sideCounter < 2; sideCounter++) {
                    for (int lengthCounter = 0; lengthCounter < 5; lengthCounter++) {
                        packageSortingCenter.getPalletIntermediateStorage().getStoredPallets()[lengthCounter][sideCounter] =
                                unloadingZone.getCurrentLKWUnloading().getTrailer().getPallets()[sideCounter][lengthCounter];
                    }
                }
            }
            unloadingZone.getCurrentLKWUnloading().getTrailer().setPallets(new Pallet[2][5]);
        }
        parkingSpot.setParkedVehicle(this);
        System.out.println("Vehicle "+id+" has returned to parking spot");
        packageSortingCenter.getCentralControlUnit().notifyEventbus(new LKWUnloadedEvent());
        System.out.println("CentralControlUnit has been informed, that vehicle has returned to spot");
    }
    @SuppressWarnings("UnstableApiUsage")
    @Subscribe
    public void receive(LKWArrivedEvent lkwArrivedEvent) {
        if (id == lkwArrivedEvent.getVehicleId()) {
            unloadLKW(lkwArrivedEvent.getZoneId());
        }
    }

    //region Getter and Setter

    //endregion

}
