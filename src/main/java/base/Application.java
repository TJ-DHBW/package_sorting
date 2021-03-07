package base;

import container.lkw.LKW;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.employee.Supervisor;

import java.io.IOException;

public class Application {
    private PackageSortingCenter packageSortingCenter;
    private Supervisor supervisor;

    public static void main(String[] args) throws IOException {
        Application application = new Application();

        application.initPackageSortingCenter();

        application.runSimulation();

        application.packageSortingCenter.getTerminal().getTouchPad().pressStatisticsButton();

        System.out.println("Done");
    }

    public void initPackageSortingCenter() {
        this.packageSortingCenter = new PackageSortingCenter();
        this.supervisor = new Supervisor(0, "Hans Peter", false);
    }

    public void runSimulation() {
        //Login
        packageSortingCenter.getTerminal().swipeCard(supervisor.getIdCard());
        packageSortingCenter.getTerminal().enterPinOrSuperPin(supervisor.getPin());

        //Process
        packageSortingCenter.getTerminal().getTouchPad().pressInitButton();
        for (LKW lkw : packageSortingCenter.getSortingFacility().getLkwWaitingArea().getLkws()) {
            packageSortingCenter.getTerminal().getTouchPad().pressNextButton();
        }
    }


    public PackageSortingCenter getPackageSortingCenter() {
        return packageSortingCenter;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }
}
