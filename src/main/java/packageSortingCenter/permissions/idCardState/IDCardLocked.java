package packageSortingCenter.permissions.idCardState;

import base.Configuration;
import packageSortingCenter.permissions.IDCard;

public class IDCardLocked implements IIDCardState {
    private boolean wrongAttempt;

    public IDCardLocked() {
        wrongAttempt = false;
    }

    private void handleWrongInput(IDCard idCard) {
        if(wrongAttempt){
            idCard.setState(new IDCardInvalid());
        }else{
            wrongAttempt = true;
        }
    }

    private void handleRightInput(IDCard idCard) {
        idCard.setState(new IDCardActive());
    }


    @Override
    public boolean checkInput(IDCard idCard, String input) {
        String clearMagnetsripe = Configuration.instance.encryptionStrategy.decrypt(new String(idCard.getMagnetStripe().getActualContent()));
        String[] fields = clearMagnetsripe.split(";");
        String decryptedPin = fields[4];

        if(input.length() == 6 && decryptedPin.startsWith(input)){
            handleRightInput(idCard);
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
