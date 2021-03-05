package packageSortingCenter.sortingFacility.sortingLanes;

import unordered.PacketType;
import container.Package;

import java.util.ArrayList;

public abstract class SortingLane {
    private SortingLane successor;
    protected ArrayList<Package> packages;

    //TODO Test for explosives

    public void sort(Package packageToSort){
        if(getSuccessor() != null){
            getSuccessor().sort(packageToSort);
        }else{
            System.out.println("There is no lane responsible for the package: " + packageToSort);
        }
    }

    protected boolean canHandlePackage(Package packageToTest, PacketType type){
        return packageToTest == null || packageToTest.getType() == type;
    }

    public SortingLane getSuccessor() {
        return successor;
    }

    public void setSuccessor(SortingLane successor) {
        this.successor = successor;
    }
}