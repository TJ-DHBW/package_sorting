package packageSortingCenter.sortingFacility.sortingLanes;

//different SearchAlgorithm could be easily implemented -> open closed principle
public interface ISearchAlgorithm {
    int search(char[] input, char[] pattern);
}
