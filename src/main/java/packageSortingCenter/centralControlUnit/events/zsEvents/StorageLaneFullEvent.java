package packageSortingCenter.centralControlUnit.events.zsEvents;

public class StorageLaneFullEvent extends ZSEvent{
    private final int id;

    public StorageLaneFullEvent(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
