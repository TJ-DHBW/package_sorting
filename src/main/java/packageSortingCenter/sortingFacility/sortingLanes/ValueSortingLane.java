package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import unordered.PacketType;

public class ValueSortingLane extends SortingLane {

    @Override
    public void sort(Package packageToSort) {
        if(canHandlePackage(packageToSort, PacketType.VALUE)){
            packages.add(packageToSort);
        }else{
            super.sort(packageToSort);
        }
    }
}
