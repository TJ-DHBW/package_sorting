package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.sortingFacility.SearchAlgorithm;
import packageSortingCenter.sortingFacility.SortingFacility;

public class ChangeSearchAlgorithmCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;
    private final SearchAlgorithm searchAlgorithm;

    public ChangeSearchAlgorithmCommand(SortingFacility sortingFacility, SearchAlgorithm searchAlgorithm) {
        this.sortingFacility = sortingFacility;
        this.searchAlgorithm = searchAlgorithm;
    }

    @Override
    public void execute() {
        //TODO implement changeSortingAlgorithm
        System.out.println("Change searchAlgorithm " + searchAlgorithm + " needs to be implemented.");
    }
}
