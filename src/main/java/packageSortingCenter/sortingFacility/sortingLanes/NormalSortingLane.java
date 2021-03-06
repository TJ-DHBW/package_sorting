package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import container.PackageType;
import packageSortingCenter.Report.ReportInformationCollector;

//Every instance of NormalSortingLane could replace SortingLane -> liskov substitution principle
public class NormalSortingLane extends SortingLane {

    public NormalSortingLane() {
        super();
    }

    @Override
    public void sort(Package packageToSort) {
        if (canHandlePackage(packageToSort, PackageType.NORMAL)) {
            if (scanner.scan(packageToSort)) {
                System.out.println("Package with explosives detected!\nPackage: " + packageToSort);
                ReportInformationCollector.getInstance().getExplosivePackages().add(packageToSort);
                return;
            }
            packages.add(packageToSort);
            ReportInformationCollector.getInstance().setNormalPackageCounter(ReportInformationCollector.getInstance().getNormalPackageCounter() + 1);
        } else {
            super.sort(packageToSort);
        }
    }
}
