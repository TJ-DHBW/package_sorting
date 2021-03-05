package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import unordered.PacketType;

public class NormalSortingLane extends SortingLane {

    @Override
    public void sort(Package packageToSort) {
        if(canHandlePackage(packageToSort, PacketType.NORMAL)){
            packages.add(packageToSort);
        }else{
            super.sort(packageToSort);
        }
    }
}
