package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.sortingFacility.SortingFacility;

public class LockCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public LockCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        //TODO implement lock
        System.out.println("Lock needs to be implemented.");
    }
}
