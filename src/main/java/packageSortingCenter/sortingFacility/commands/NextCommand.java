package packageSortingCenter.sortingFacility.commands;

import base.Configuration;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.Report.ReportInformationCollector;
import packageSortingCenter.UnloadingZone;
import packageSortingCenter.sortingFacility.SortingFacility;

public class NextCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;


    public NextCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        PackageSortingCenter packageSortingCenter = sortingFacility.getPackageSortingCenter();
        for(UnloadingZone unloadingZone : packageSortingCenter.getUnloadingZones()){
            if(unloadingZone.getCurrentLKWUnloading() != null){
                unloadingZone.setCurrentLKWUnloading(null);
            }
        }

        int randomUnloadingZone = Configuration.instance.randomGenerator.nextInt(packageSortingCenter.getUnloadingZones().length);
        packageSortingCenter.getUnloadingZones()[randomUnloadingZone]
                .setCurrentLKWUnloading(packageSortingCenter.getSortingFacility().getLkwWaitingArea().getLkws()[packageSortingCenter.getCurrentLKW()]);
        packageSortingCenter.getSortingFacility().getLkwWaitingArea().getLkws()[packageSortingCenter.getCurrentLKW()] = null;
        packageSortingCenter.setCurrentLKW(packageSortingCenter.getCurrentLKW() + 1);

        ReportInformationCollector.getInstance().setNumberOfHandledLkw(ReportInformationCollector.getInstance().getNumberOfHandledLkw()+1);
    }
}
