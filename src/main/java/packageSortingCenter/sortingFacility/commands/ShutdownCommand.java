package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.UnloadingZone;
import packageSortingCenter.sortingFacility.SortingFacility;
import packageSortingCenter.sortingFacility.sortingLanes.Scanner;

public class ShutdownCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public ShutdownCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        for(UnloadingZone unloadingZone : sortingFacility.getPackageSortingCenter().getUnloadingZones()){
            unloadingZone.getSensor().setActivated(false);
        }
        Scanner.shutdownScanner();
    }
}
