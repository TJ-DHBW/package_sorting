package packageSortingCenter.employee;

public class Operator extends Employee {
    //Every instance of Operator could replace Employee -> liskov substitution principle
    public Operator(int id, String name) {
        super(id, name);
    }
}
