package packageSortingCenter.terminal;

import base.Configuration;
import packageSortingCenter.permissions.CardReader;
import packageSortingCenter.permissions.IDCard;
import packageSortingCenter.sortingFacility.SortingFacility;
import packageSortingCenter.sortingFacility.SortingFacilityProxy;

public class Terminal {
    private final CardReader cardReader;
    private final SortingFacility sortingFacility;
    private final TouchPad touchPad;


    /*
    How to use this:
    - Swipe Card
    - Enter Pin
    - Send Command via TouchPad
     */
    public Terminal(SortingFacility connectedSortingFacility) {
        this.cardReader = new CardReader();
        this.sortingFacility = connectedSortingFacility;
        this.touchPad = new TouchPad();
    }


    public void swipeCard(IDCard idCard) {
        cardReader.swipeCard(idCard);
    }

    public void enterPinOrSuperPin(String pin) {
        IDCard verifiedCard = cardReader.enterPinOrSuperPin(pin);

        if (verifiedCard != null) {
            //Create the Proxy
            String magnetStripeContent = Configuration.instance.encryptionStrategy.decrypt(new String(verifiedCard.getMagnetStripe().getActualContent()));
            String[] fields = magnetStripeContent.split(";");
            SortingFacilityProxy proxy = sortingFacility.getProxy(fields[2]);

            touchPad.setCurrentProxy(proxy);
        }
    }

    public TouchPad getTouchPad() {
        return touchPad;
    }
}
