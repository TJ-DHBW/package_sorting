package packageSortingCenter.employee;

public class Supervisor extends Employee {
    private boolean isSenior;

    public Supervisor(int id, String name, boolean isSenior) {
        super(id, name);
        this.isSenior = isSenior;
    }
}
