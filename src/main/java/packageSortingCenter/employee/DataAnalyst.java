package packageSortingCenter.employee;

//Every instance of DataAnalyst could replace Employee -> liskov substitution principle
public class DataAnalyst extends Employee {
    public DataAnalyst(int id, String name) {
        super(id, name);
    }
}
