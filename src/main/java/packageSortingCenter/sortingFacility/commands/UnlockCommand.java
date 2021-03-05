package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.sortingFacility.SortingFacility;

public class UnlockCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public UnlockCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        sortingFacility.setLocked(false);
    }
}
