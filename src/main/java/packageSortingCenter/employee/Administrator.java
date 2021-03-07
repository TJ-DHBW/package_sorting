package packageSortingCenter.employee;

//Every instance of Administrator could replace Employee -> liskov substitution principle
public class Administrator extends Employee {
    private AdministratorProfile profile;

    public Administrator(int id, String name, AdministratorProfile profile) {
        super(id, name);
        this.profile = profile;
    }
}
