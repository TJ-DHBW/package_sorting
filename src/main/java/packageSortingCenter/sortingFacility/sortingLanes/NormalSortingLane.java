package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import packageSortingCenter.Report.ReportInformationCollector;
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
                ReportInformationCollector.getInstance().getExplosivePackages().add(packageToSort);
                return;
            }
            packages.add(packageToSort);
            ReportInformationCollector.getInstance().setNormalPackageCounter(ReportInformationCollector.getInstance().getNormalPackageCounter()+1);
        }else{
            super.sort(packageToSort);
        }
    }
}
