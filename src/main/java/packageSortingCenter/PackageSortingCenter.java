package packageSortingCenter;

import packageSortingCenter.centralControlUnit.CentralControlUnit;
import packageSortingCenter.sortingFacility.SortingFacility;
import packageSortingCenter.terminal.Terminal;

import java.util.Arrays;
import java.util.List;

public class PackageSortingCenter {
    private final CentralControlUnit centralControlUnit;
    private final UnloadingZone[] unloadingZones;
    private final ParkingZone parkingZone;
    private final SortingFacility sortingFacility;
    private final Terminal terminal;

    public PackageSortingCenter() {
        this.unloadingZones = new UnloadingZone[] {new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone(),
                new UnloadingZone()
        };
        this.parkingZone = new ParkingZone();
        this.sortingFacility = new SortingFacility();
        this.terminal = new Terminal(sortingFacility);

        this.centralControlUnit = new CentralControlUnit();
        connectToCentralControlUnit();
    }

    private void connectToCentralControlUnit(){
        //TODO connect all the stuff to the central control unit
    }

    public List<UnloadingZone> getUnloadingZonesAsList(){
        return Arrays.asList(unloadingZones);
    }

    public Terminal getTerminal() {
        return terminal;
    }
}
