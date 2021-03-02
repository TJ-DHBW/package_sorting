package packageSortingCenter.permissions.idCardState;

import packageSortingCenter.permissions.IDCard;

public class IDCardInvalid implements IIDCardState {

    @Override
    public boolean checkInput(IDCard idCard, String input) {
        System.out.println("This card: " + idCard + " is invalid!");
        return false;
    }

    @Override
    public boolean shouldBeAccepted() {
        return false;
    }
}
