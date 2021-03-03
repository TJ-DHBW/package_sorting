package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.sortingFacility.SortingFacility;

public class UnlockCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public UnlockCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        //TODO implement unlock
        System.out.println("Unlock needs to be implemented.");
    }
}
