package packageSortingCenter;

import packageSortingCenter.centralControlUnit.CentralControlUnit;
import packageSortingCenter.sortingFacility.SortingFacility;
import packageSortingCenter.sortingFacility.StorageLane;
import packageSortingCenter.terminal.Terminal;

import java.util.Arrays;
import java.util.List;

public class PackageSortingCenter {
    private final CentralControlUnit centralControlUnit;
    private final UnloadingZone[] unloadingZones;
    private final ParkingZone parkingZone;
    private final SortingFacility sortingFacility;
    private final Terminal terminal;
    private final PalletIntermediateStorage palletIntermediateStorage = new PalletIntermediateStorage();

    private Integer currentLKW = 0;

    public PackageSortingCenter() {
        this.unloadingZones = new UnloadingZone[] {new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone()
        };
        this.sortingFacility = new SortingFacility(this);
        this.parkingZone = new ParkingZone(this);
        this.terminal = new Terminal(sortingFacility);

        this.centralControlUnit = new CentralControlUnit(parkingZone.getParkingSpots().length);
        connectToCentralControlUnit();
    }

    private void connectToCentralControlUnit(){
        for(ParkingSpot parkingSpot : parkingZone.getParkingSpots()) {
            centralControlUnit.subscribe(parkingSpot.getParkedVehicle());
        }
        for(StorageLane storageLane : this.sortingFacility.getStorageLanes()){
            storageLane.getSensor().addListener(centralControlUnit);
        }
        centralControlUnit.subscribe(sortingFacility.getPrestoredRobot());
    }

    //region Getter and Setter
    public List<UnloadingZone> getUnloadingZonesAsList(){
        return Arrays.asList(unloadingZones);
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public UnloadingZone[] getUnloadingZones() {
        return unloadingZones;
    }

    public ParkingZone getParkingZone() {
        return parkingZone;
    }

    public SortingFacility getSortingFacility() {
        return sortingFacility;
    }

    public PalletIntermediateStorage getPalletIntermediateStorage() {
        return palletIntermediateStorage;
    }

    public CentralControlUnit getCentralControlUnit() {
        return centralControlUnit;
    }

    public Integer getCurrentLKW() {
        return currentLKW;
    }

    public void setCurrentLKW(Integer currentLKW) {
        this.currentLKW = currentLKW;
    }

    //endregion
}
