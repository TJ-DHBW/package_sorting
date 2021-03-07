package packageSortingCenter.permissions.idCardState;

import packageSortingCenter.permissions.IDCard;

//additional IDCardStates could be easily added -> open closed principle
//IDCardState has only checkInput and shouldBeAccepted, even though two children have the functions
// handleWrongInput and handleRightInput -> liskov substitution principle
public interface IIDCardState {
    /**
     * checks if a given input is valid for a cards state
     *
     * @param idCard The card this state belongs to
     * @param input  The input to test.
     * @return True if valid. False if invalid.
     */
    boolean checkInput(IDCard idCard, String input);

    boolean shouldBeAccepted();
}
