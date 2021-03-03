package packageSortingCenter.sortingFacility;

public interface ISortingFacility {
    void init();

    void next();

    void shutdown();

    void lock();

    void unlock();

    void showStatistics();

    void changeSearchAlgorithm(SearchAlgorithm algorithm);
}
