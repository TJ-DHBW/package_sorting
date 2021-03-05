package packageSortingCenter.sortingFacility;
import container.Pallet;
import packageSortingCenter.LkwWaitingArea;
import packageSortingCenter.employee.Employee;
import packageSortingCenter.sortingFacility.commands.*;
import packageSortingCenter.sortingFacility.sortingLanes.ExpressSortingLane;
import packageSortingCenter.sortingFacility.sortingLanes.NormalSortingLane;
import packageSortingCenter.sortingFacility.sortingLanes.SortingLane;
import packageSortingCenter.sortingFacility.sortingLanes.ValueSortingLane;
import container.Box;

import java.util.HashMap;

public class SortingFacility implements ISortingFacility{
    private final HashMap<String, ISortingFacilityCommand> commands;
    private LkwWaitingArea lkwWaitingArea = new LkwWaitingArea();
    private final Robot prestoredRobot;
    private final StoragePlace<Box> boxStoragePlace;
    private final StoragePlace<Pallet> palletStoragePlace;
    private final StorageLane[] storageLanes;
    //TODO Eins reterded Sensor for ze StorageLane/s.
    private final SortingLane[] sortingLanes;


    public SortingFacility() {
        this.prestoredRobot = new Robot();
        this.boxStoragePlace = new StoragePlace<>();
        this.palletStoragePlace = new StoragePlace<>();
        this.storageLanes = new StorageLane[]{new StorageLane(600),
                new StorageLane(600),
                new StorageLane(600),
                new StorageLane(600),
                new StorageLane(600),
                new StorageLane(600),
                new StorageLane(600),
                new StorageLane(600)};
        this.sortingLanes = new SortingLane[]{new NormalSortingLane(),
                new ValueSortingLane(),
                new ExpressSortingLane()}; //TODO rename PacketType to PackageType
        this.sortingLanes[0].setSuccessor(this.sortingLanes[1]);
        this.sortingLanes[1].setSuccessor(this.sortingLanes[2]);

        this.commands = createCommands();
    }


    @Override
    public void init() {
        if(!executeIfFound("1")) throw new IllegalStateException("There should be a command to execute!");
    }

    @Override
    public void next() {
        if(!executeIfFound("2")) throw new IllegalStateException("There should be a command to execute!");
    }

    @Override
    public void shutdown() {
        if(!executeIfFound("3")) throw new IllegalStateException("There should be a command to execute!");
    }

    @Override
    public void lock() {
        if(!executeIfFound("4")) throw new IllegalStateException("There should be a command to execute!");
    }

    @Override
    public void unlock() {
        if(!executeIfFound("5")) throw new IllegalStateException("There should be a command to execute!");
    }

    @Override
    public void showStatistics() {
        if(!executeIfFound("6")) throw new IllegalStateException("There should be a command to execute!");
    }

    @Override
    public void changeSearchAlgorithm(SearchAlgorithm algorithm) {
        switch(algorithm){
            case BM:
                if(!executeIfFound("7.1")) throw new IllegalStateException("There should be a command to execute!");
                return;
            case KMP:
                if(!executeIfFound("7.2")) throw new IllegalStateException("There should be a command to execute!");
                return;
            default:
                throw new UnsupportedOperationException("This is not implemented yet.");
        }
    }


    private HashMap<String, ISortingFacilityCommand> createCommands(){
        HashMap<String, ISortingFacilityCommand> ret = new HashMap<>();

        // [i]init, [ii]next, [iii]shutdown, [iv]lock, [v]unlock, [vi]show statistics, [vii]  change  search  algorithm
        ret.put("1", new InitCommand(this));
        ret.put("2", new NextCommand(this));
        ret.put("3", new ShutdownCommand(this));
        ret.put("4", new LockCommand(this));
        ret.put("5", new UnlockCommand(this));
        ret.put("6", new ShowStatisticsCommand(this));
        ret.put("7.1", new ChangeSearchAlgorithmCommand(this, SearchAlgorithm.BM));
        ret.put("7.2", new ChangeSearchAlgorithmCommand(this, SearchAlgorithm.KMP));

        return ret;
    }

    private boolean executeIfFound(String commandIdentifier){
        if(commands.containsKey(commandIdentifier)){
            commands.get(commandIdentifier).execute();
            return true;
        }
        return false;
    }

    public SortingFacilityProxy getProxy(String employeeType){
        return new SortingFacilityProxy(this, employeeType);
    }

    //region Getter und Setter

    public LkwWaitingArea getLkwWaitingArea() {
        return lkwWaitingArea;
    }

    public void setLkwWaitingArea(LkwWaitingArea lkwWaitingArea) {
        this.lkwWaitingArea = lkwWaitingArea;
    }

    public StorageLane[] getStorageLanes() {
        return storageLanes;
    }

    //endregion
}
