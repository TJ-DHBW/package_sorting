package packageSortingCenter.sortingFacility;

import packageSortingCenter.employee.*;

import java.util.HashMap;

public class SortingFacilityProxy implements ISortingFacility {
    private static final HashMap<Class<? extends Employee>, char[]> permissions;

    static {
        permissions = new HashMap<>();
        // [i]init, [ii]next, [iii]shutdown, [iv]lock, [v]unlock, [vi]show statistics, [vii]  change  search  algorithm
        permissions.put(Supervisor.class, new char[]{'+', '+', '+', '+', '+', '+', '+'});
        permissions.put(Administrator.class, new char[]{'-', '-', '+', '-', '-', '+', '-'});
        permissions.put(Operator.class, new char[]{'-', '+', '-', '-', '-', '+', '-'});
        permissions.put(DataAnalyst.class, new char[]{'-', '-', '-', '-', '-', '+', '-'});
    }

    private final SortingFacility sortingFacility;
    private final Class<? extends Employee> employeeClass;

    public SortingFacilityProxy(SortingFacility sortingFacility, String employeeType) {
        this.sortingFacility = sortingFacility;

        this.employeeClass = employeeTypeToClass(employeeType);
        if (employeeClass == null)
            throw new IllegalStateException("A Proxy should not exist without knowing what privileges it has.");
    }


    private static Class<? extends Employee> employeeTypeToClass(String employeeType) {
        try {
            Class c = Class.forName("packageSortingCenter.employee." + employeeType);
            if (c.getSuperclass() == Employee.class) return (Class<? extends Employee>) c;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("The argument hast to be the classname of an Employee.");
        }
        return null;
    }

    @Override
    public void init() {
        if (checkPermission(1)) {
            sortingFacility.init();
        } else {
            System.out.println("Access denied!");
        }
    }

    @Override
    public void next() {
        if (checkPermission(2)) {
            sortingFacility.next();
        } else {
            System.out.println("Access denied!");
        }
    }

    @Override
    public void shutdown() {
        if (checkPermission(3)) {
            sortingFacility.shutdown();
        } else {
            System.out.println("Access denied!");
        }
    }

    @Override
    public void lock() {
        if (checkPermission(4)) {
            sortingFacility.lock();
        } else {
            System.out.println("Access denied!");
        }
    }

    @Override
    public void unlock() {
        if (checkPermission(5)) {
            sortingFacility.unlock();
        } else {
            System.out.println("Access denied!");
        }
    }

    @Override
    public void showStatistics() {
        if (checkPermission(6)) {
            sortingFacility.showStatistics();
        } else {
            System.out.println("Access denied!");
        }
    }

    @Override
    public void changeSearchAlgorithm(SearchAlgorithm algorithm) {
        if (checkPermission(7)) {
            sortingFacility.changeSearchAlgorithm(algorithm);
        } else {
            System.out.println("Access denied!");
        }
    }

    /**
     * Checks if the employee is allowed to use a certain function.
     *
     * @param commandId The Id from the specification for the command
     * @return True - If the employee has permissions.<br>False - If the employee does not have permission.
     */
    private boolean checkPermission(int commandId) {
        if (permissions.containsKey(employeeClass)) {
            char[] permissionArray = permissions.get(employeeClass);
            if (commandId > permissionArray.length || commandId < 1)
                throw new IllegalArgumentException("CommandId must be between 1 and " + permissionArray.length);

            return permissionArray[commandId - 1] == '+';
        }
        return false;
    }
}
