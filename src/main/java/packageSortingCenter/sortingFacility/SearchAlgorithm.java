package packageSortingCenter.sortingFacility;

public enum SearchAlgorithm {
    BM, RK;

    public String toProjectName() {
        switch (this) {
            case BM:
                return "boyerMoore";
            case RK:
                return "rabinKarp";
        }
        return null;
    }

    public String toMainClassName() {
        switch (this) {
            case BM:
                return "packageSortingCenter.sortingFacility.sortingLanes.BoyerMoore";
            case RK:
                return "packageSortingCenter.sortingFacility.sortingLanes.RabinKarp";
        }
        return null;
    }
}
