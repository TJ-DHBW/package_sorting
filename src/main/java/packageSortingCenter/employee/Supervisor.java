package packageSortingCenter.employee;

//Every instance of Supervisor could replace Employee -> liskov substitution principle
public class Supervisor extends Employee {
    private boolean isSenior;

    public Supervisor(int id, String name, boolean isSenior) {
        super(id, name);
        this.isSenior = isSenior;
    }
}
