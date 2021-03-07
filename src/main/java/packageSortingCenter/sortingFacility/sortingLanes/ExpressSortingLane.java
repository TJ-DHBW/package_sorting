package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import packageSortingCenter.Report.ReportInformationCollector;
import container.PackageType;

//Every instance of NormalSortingLane could replace SortingLane -> liskov substitution principle
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
