package packageSortingCenter.sortingFacility.commands;

import base.Configuration;
import packageSortingCenter.Report.Report;
import packageSortingCenter.Report.ReportInformationCollector;
import packageSortingCenter.sortingFacility.SortingFacility;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ShowStatisticsCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public ShowStatisticsCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        Report report = new Report.Builder()
                .date(new Date())
                .numberOfHandledLKW(ReportInformationCollector.getInstance().getNumberOfHandledLkw())
                .scannedPackagesNormal(ReportInformationCollector.getInstance().getNormalPackageCounter())
                .scannedPackagesExpress(ReportInformationCollector.getInstance().getExpressPackageCounter())
                .scannedPackagesValue(ReportInformationCollector.getInstance().getValuePackageCounter())
                .packagesWithExplosives(ReportInformationCollector.getInstance().getExplosivePackages())
                .build();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.instance.exportDirectory + "report.txt"));
            writer.write(report.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
