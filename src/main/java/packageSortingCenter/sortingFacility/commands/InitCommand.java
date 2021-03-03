package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.sortingFacility.SortingFacility;

public class InitCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public InitCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        //TODO implement Init
        System.out.println("Init needs to be implemented.");
    }
}
