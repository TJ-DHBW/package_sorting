package packageSortingCenter;

public class ParkingZone {
    private PackageSortingCenter packageSortingCenter;
    private ParkingSpot[] parkingSpots;

    public ParkingZone(PackageSortingCenter packageSortingCenter) {
        this.packageSortingCenter = packageSortingCenter;
        parkingSpots = new ParkingSpot[5];
        for (int i = 0; i < 5; i++) {
            parkingSpots[i] = new ParkingSpot();
            AutonomousVehicle autonomousVehicle = new AutonomousVehicle(packageSortingCenter, parkingSpots[i]);
            parkingSpots[i].setParkedVehicle(autonomousVehicle);
        }
    }
    //region  Getter and Setter

    public ParkingSpot[] getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(ParkingSpot[] parkingSpots) {
        this.parkingSpots = parkingSpots;
    }


    //endregion
}
