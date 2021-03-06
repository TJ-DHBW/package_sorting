package packageSortingCenter.sortingFacility.sortingLanes;

import container.Package;
import container.PackageType;
import packageSortingCenter.Report.ReportInformationCollector;

//Every instance of ValueSortingLane could replace SortingLane -> liskov substitution principle
public class ValueSortingLane extends SortingLane {

    public ValueSortingLane() {
        super();
    }

    @Override
    public void sort(Package packageToSort) {
        if (canHandlePackage(packageToSort, PackageType.VALUE)) {
            if (scanner.scan(packageToSort)) {
                System.out.println("Package with explosives detected!\nPackage: " + packageToSort);
                ReportInformationCollector.getInstance().getExplosivePackages().add(packageToSort);
                return;
            }
            packages.add(packageToSort);
            ReportInformationCollector.getInstance().setValuePackageCounter(ReportInformationCollector.getInstance().getValuePackageCounter() + 1);
        } else {
            super.sort(packageToSort);
        }
    }
}
