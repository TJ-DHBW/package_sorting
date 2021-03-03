package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.sortingFacility.SortingFacility;

public class ShutdownCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public ShutdownCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        //TODO implement shutdown
        System.out.println("Shutdown needs to be implemented.");
    }
}
