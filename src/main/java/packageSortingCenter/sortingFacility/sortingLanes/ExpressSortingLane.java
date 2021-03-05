package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import packageSortingCenter.Report.ReportInformationCollector;
import unordered.PacketType;

public class ExpressSortingLane extends SortingLane {

    public ExpressSortingLane() {
        super();
    }

    @Override
    public void sort(Package packageToSort) {
        if(canHandlePackage(packageToSort, PackageType.EXPRESS)){
            if(scanner.scan(packageToSort)){
                System.out.println("Package with explosives detected!\nPackage: " + packageToSort);
                ReportInformationCollector.getInstance().getExplosivePackages().add(packageToSort);
                return;
            }
            ReportInformationCollector.getInstance().setExpressPackageCounter(ReportInformationCollector.getInstance().getExpressPackageCounter()+1);
            packages.add(packageToSort);
        }else{
            super.sort(packageToSort);
        }
    }
}
