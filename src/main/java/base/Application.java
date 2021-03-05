package base;

import container.Box;
import container.Package;
import container.Pallet;
import container.generator.*;
import container.lkw.LKW;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.employee.*;
import packageSortingCenter.permissions.IDCard;
import packageSortingCenter.sortingFacility.SortingFacility;
import packageSortingCenter.sortingFacility.SortingFacilityProxy;
import packageSortingCenter.terminal.Terminal;
import packageSortingCenter.terminal.TouchPad;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        terminalStuff();
    }

    public static void terminalStuff(){
        PackageSortingCenter packageSortingCenter = new PackageSortingCenter();
        SortingFacility sortingFacility = new SortingFacility(packageSortingCenter);
        Terminal terminal = new Terminal(sortingFacility);

        Supervisor supervisor = new Supervisor(0, "Joe", false);
        Administrator administrator = new Administrator(1, "Bob", AdministratorProfile.A);
        Operator operator = new Operator(2, "Belle");
        DataAnalyst dataAnalyst = new DataAnalyst(3, "Sarah");

        terminal.swipeCard(supervisor.getIdCard());
        terminal.enterPinOrSuperPin(supervisor.getPin());
        TouchPad touchPad = terminal.getTouchPad();
        touchPad.pressInitButton();
        touchPad.pressNextButton();
        touchPad.pressShutdownButton();
        touchPad.pressLockButton();
        touchPad.pressUnlockButton();
        touchPad.pressStatisticsButton();
        touchPad.pressSearchAlgorithmToBMButton();
        touchPad.pressSearchAlgorithmToKMPButton();
        System.out.println("-------------------\n");

        terminal.swipeCard(administrator.getIdCard());
        terminal.enterPinOrSuperPin("1234");
        terminal.swipeCard(administrator.getIdCard());
        terminal.enterPinOrSuperPin("1234");
        terminal.swipeCard(administrator.getIdCard());
        terminal.enterPinOrSuperPin("1234");
        terminal.swipeCard(administrator.getIdCard());
        terminal.enterPinOrSuperPin(administrator.getSuperPin());
        touchPad.pressInitButton();
        touchPad.pressNextButton();
        touchPad.pressShutdownButton();
        touchPad.pressLockButton();
        touchPad.pressUnlockButton();
        touchPad.pressStatisticsButton();
        touchPad.pressSearchAlgorithmToBMButton();
        touchPad.pressSearchAlgorithmToKMPButton();
        System.out.println("-------------------\n");

        terminal.swipeCard(operator.getIdCard());
        terminal.enterPinOrSuperPin("1234");
        terminal.swipeCard(operator.getIdCard());
        terminal.enterPinOrSuperPin("1234");
        terminal.swipeCard(operator.getIdCard());
        terminal.enterPinOrSuperPin("1234");
        terminal.swipeCard(operator.getIdCard());
        terminal.enterPinOrSuperPin("123456");
        terminal.swipeCard(operator.getIdCard());
        terminal.enterPinOrSuperPin("123456");
        System.out.println("-------------------\n");

        IDCard invalidCard = operator.getIdCard();

        terminal.swipeCard(operator.getIdCard());
        terminal.enterPinOrSuperPin("123456");

        System.out.println("Done");
    }
}
