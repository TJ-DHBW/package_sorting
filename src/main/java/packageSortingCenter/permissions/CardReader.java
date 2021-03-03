package packageSortingCenter.permissions;

public class CardReader {
    /*
    Employee zieht Card durch reader    --> swipeCard() bei CardReader
    und wird zu pineingabe aufgefordert --> enterPin() bei CardReader
     */
    private IDCard idCard;


    public void swipeCard(IDCard card){
        if(card.shouldBeAccepted()){
            idCard = card;
        }else{
            System.out.println("Card not accepted.");
        }
    }

    public IDCard enterPinOrSuperPin(String pin){
        if(idCard == null){
            System.out.println("Please swipe a valid card before entering a pin.");
            return null;
        }

        boolean success = idCard.checkInput(pin);

        if(success){
            System.out.println("ID verified.");
            IDCard tmp = idCard;
            idCard = null;
            return tmp;
        }else{
            System.out.println("Could not verify.");
            idCard = null;
            return null;
        }
    }
}
