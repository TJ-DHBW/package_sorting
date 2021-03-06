package packageSortingCenter.employee;

import packageSortingCenter.permissions.IDCard;

//Employee does not depend on its child classes -> dependency inversion principle
public abstract class Employee {
    private int id;
    private String name;
    private IDCard idCard;

    private String pin;
    private String superPin;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        idCard = IDCard.issueIDCardForEmployee(this);
    }


    public void rememberPin(String pin) {
        this.pin = pin;
    }

    public void rememberSuperPin(String superPin) {
        this.superPin = superPin;
    }


    public String getPin() {
        return pin;
    }

    public String getSuperPin() {
        return superPin;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IDCard getIdCard() {
        return idCard;
    }
}
