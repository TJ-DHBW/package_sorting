package packageSortingCenter.sortingFacility.commands;

import base.Configuration;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.UnloadingZone;
import packageSortingCenter.sortingFacility.SortingFacility;

public class NextCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;
    private final PackageSortingCenter packageSortingCenter;

    public NextCommand(SortingFacility sortingFacility, PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        for(UnloadingZone unloadingZone : packageSortingCenter.getUnloadingZones()){
            if(unloadingZone.getCurrentLKWUnloading() != null){
                unloadingZone.setCurrentLKWUnloading(null);
            }
        }
        int randomUnloadingZone = Configuration.instance.randomGenerator.nextInt(packageSortingCenter.getUnloadingZones().length);
        packageSortingCenter.getUnloadingZones()[randomUnloadingZone]
                .setCurrentLKWUnloading(packageSortingCenter.getSortingFacility().getLkwWaitingArea().getLkws()[packageSortingCenter.getCurrentLKW()]);
    }
}
