package packageSortingCenter.permissions.idCardState;

import packageSortingCenter.permissions.IDCard;

//additional IDCardStates could be easily added -> open closed principle
public interface IIDCardState {
    /**
     * checks if a given input is valid for a cards state
     * @param idCard The card this state belongs to
     * @param input  The input to test.
     * @return True if valid. False if invalid.
     */
    boolean checkInput(IDCard idCard, String input);

    boolean shouldBeAccepted();
}
