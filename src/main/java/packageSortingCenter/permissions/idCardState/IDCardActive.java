package packageSortingCenter.permissions.idCardState;

import base.Configuration;
import packageSortingCenter.permissions.IDCard;

public class IDCardActive implements IIDCardState {
    private int incorrectAttempts;

    public IDCardActive() {
        this.incorrectAttempts = 0;
    }

    private void handleWrongInput(IDCard idCard) {
        if(incorrectAttempts >= 2){
            idCard.setState(new IDCardLocked());
        }else{
            incorrectAttempts++;
        }
    }

    private void handleRightInput() {
        incorrectAttempts = 0;
    }


    @Override
    public boolean checkInput(IDCard idCard, String input) {
        String clearMagnetsripe = Configuration.instance.encryptionStrategy.decrypt(new String(idCard.getMagnetStripe().getContent()));
        String[] fields = clearMagnetsripe.split(";");
        String decryptedPin = fields[3];

        if(input.equals(decryptedPin)){
            handleRightInput();
            return true;
        }else{
            handleWrongInput(idCard);
            return false;
        }
    }

    @Override
    public boolean shouldBeAccepted() {
        return true;
    }
}
