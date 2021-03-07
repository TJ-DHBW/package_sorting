import base.Application;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import packageSortingCenter.PackageSortingCenter;
import packageSortingCenter.centralControlUnit.events.zsEvents.LKWUnloadedEvent;

public class ScenarioTests {
    private Application application;
    private EventReciever eventReciever;

    @Before
    public void initialize(){
        application = new Application();
        application.initPackageSortingCenter();

        eventReciever = new EventReciever();
        application.getPackageSortingCenter().getCentralControlUnit().subscribe(eventReciever);
    }

    @Test
    public void correctNumberOfComponentsAfterSetup(){
        PackageSortingCenter psc = application.getPackageSortingCenter();
        Assert.assertNotNull(psc);

        Assert.assertNotNull(psc.getCentralControlUnit());
        
        Assert.assertNotNull(psc.getUnloadingZones());
        Assert.assertEquals(7, psc.getUnloadingZones().length);

        Assert.assertNotNull(psc.getParkingZone());
        Assert.assertNotNull(psc.getParkingZone().getParkingSpots());
        Assert.assertEquals(5, psc.getParkingZone().getParkingSpots().length);

        Assert.assertNotNull(psc.getSortingFacility());
    }

    @Test
    public void autonomousVehicleUnloadsWholeLkw(){
        application.runSimulation();

        Assert.assertTrue(eventReciever.receivedEventOfClass(LKWUnloadedEvent.class));
    }
}
