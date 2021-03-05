package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import unordered.PacketType;

public class ValueSortingLane extends SortingLane {

    public ValueSortingLane() {
        super();
    }

    @Override
    public void sort(Package packageToSort) {
        if(canHandlePackage(packageToSort, PacketType.VALUE)){
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
