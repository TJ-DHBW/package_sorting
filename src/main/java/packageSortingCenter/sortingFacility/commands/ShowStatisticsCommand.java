package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.sortingFacility.SortingFacility;

public class ShowStatisticsCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public ShowStatisticsCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        //TODO implement showStatistics
        System.out.println("Show Statistics needs to be implemented.");
    }
}
