package packageSortingCenter.sortingFacility.commands;

import packageSortingCenter.sortingFacility.SearchAlgorithm;
import packageSortingCenter.sortingFacility.sortingLanes.Scanner;

public class ChangeSearchAlgorithmCommand implements ISortingFacilityCommand {
    private final SearchAlgorithm searchAlgorithm;

    public ChangeSearchAlgorithmCommand(SearchAlgorithm searchAlgorithm) {
        this.searchAlgorithm = searchAlgorithm;
    }

    @Override
    public void execute() {
        Scanner.changeSearchAlgorithm(searchAlgorithm);
    }
}
