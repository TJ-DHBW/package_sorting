package packageSortingCenter.sortingFacility;

import packageSortingCenter.employee.Employee;
import packageSortingCenter.sortingFacility.commands.*;

import java.util.HashMap;

public class SortingFacility implements ISortingFacility{
    private final HashMap<String, ISortingFacilityCommand> commands;

    public SortingFacility() {
        commands = createCommands();
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
}
