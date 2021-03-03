package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.sortingFacility.SortingFacility;

public class NextCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public NextCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        //TODO implement next
        System.out.println("Next needs to be implemented.");
    }
}
