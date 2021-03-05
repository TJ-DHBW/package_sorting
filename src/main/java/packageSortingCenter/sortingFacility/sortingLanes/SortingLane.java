package packageSortingCenter.sortingFacility.sortingLanes;

import unordered.PackageType;
import container.Package;

import java.util.ArrayList;

public abstract class SortingLane {
    private SortingLane successor;
    protected ArrayList<Package> packages;
    protected Scanner scanner;

    public SortingLane() {
        this.scanner = new Scanner();
    }


    public void sort(Package packageToSort){
        if(getSuccessor() != null){
            getSuccessor().sort(packageToSort);
        }else{
            System.out.println("There is no lane responsible for the package: " + packageToSort);
        }
    }

    protected boolean canHandlePackage(Package packageToTest, PackageType type){
        return packageToTest == null || packageToTest.getType() == type;
    }

    public SortingLane getSuccessor() {
        return successor;
    }

    public void setSuccessor(SortingLane successor) {
        this.successor = successor;
    }
}
