package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import container.PackageType;

import java.util.ArrayList;

//SortingLane does not depend on its child classes -> dependency inversion principle
public abstract class SortingLane {
    protected ArrayList<Package> packages;
    protected Scanner scanner;
    private SortingLane successor;

    public SortingLane() {
        this.scanner = new Scanner();
        this.packages = new ArrayList<>();
    }


    public void sort(Package packageToSort) {
        if (getSuccessor() != null) {
            getSuccessor().sort(packageToSort);
        } else {
            System.out.println("There is no lane responsible for the package: " + packageToSort);
        }
    }

    protected boolean canHandlePackage(Package packageToTest, PackageType type) {
        return packageToTest == null || packageToTest.getType() == type;
    }

    public SortingLane getSuccessor() {
        return successor;
    }

    public void setSuccessor(SortingLane successor) {
        this.successor = successor;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
