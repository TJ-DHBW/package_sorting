package packageSortingCenter.centralControlUnit.events.general;


public class LKWArrivedEvent {
    private int zoneId;
    private int vehicleId;

    public LKWArrivedEvent(int zoneId, int vehicleId) {
        this.zoneId = zoneId;
        this.vehicleId = vehicleId;
    }

    //region Getter und Setter
    public int getZoneId() {
        return zoneId;
    }

    public int getVehicleId() {
        return vehicleId;
    }
    //region
}
