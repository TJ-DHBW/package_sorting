package packageSortingCenter.employee;

public class Administrator extends Employee {
    private AdministratorProfile profile;

    public Administrator(int id, String name, AdministratorProfile profile) {
        super(id, name);
        this.profile = profile;
    }
}
