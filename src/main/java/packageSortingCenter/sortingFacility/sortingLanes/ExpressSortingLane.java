package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import unordered.PacketType;

public class ExpressSortingLane extends SortingLane {

    @Override
    public void sort(Package packageToSort) {
        if(canHandlePackage(packageToSort, PacketType.EXPRESS)){
            packages.add(packageToSort);
        }else{
            super.sort(packageToSort);
        }
    }
}
