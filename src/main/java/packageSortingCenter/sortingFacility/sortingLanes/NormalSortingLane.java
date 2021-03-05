package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import unordered.PacketType;

public class NormalSortingLane extends SortingLane {

    public NormalSortingLane() {
        super();
    }

    @Override
    public void sort(Package packageToSort) {
        if(canHandlePackage(packageToSort, PacketType.NORMAL)){
            if(scanner.scan(packageToSort)){
                System.out.println("Package with explosives detected!\nPackage: " + packageToSort);
                return;
            }
            packages.add(packageToSort);
        }else{
            super.sort(packageToSort);
        }
    }
}
