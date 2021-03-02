package packageSortingCenter.permissions;

import base.Configuration;
import packageSortingCenter.employee.Employee;
import packageSortingCenter.permissions.idCardState.IIDCardState;

public class IDCard {
    private final MagnetStripe magnetStripe;
    private IIDCardState state;

    private IDCard(MagnetStripe magnetStripe) {
        this.magnetStripe = magnetStripe;
        //TODO initialize state and write the checkInput method
    }

    public static IDCard issueIDCardForEmployee(Employee employee){
        // Create Pin
        StringBuilder pinBuilder = new StringBuilder();
        for(int i = 0; i < 4; i++){
            pinBuilder.append(Configuration.instance.randomGenerator.nextInt(10));
        }
        String pin = pinBuilder.toString();

        // Create SuperPin
        StringBuilder superPinBuilder = new StringBuilder();
        for(int i = 0; i < 10; i++){
            superPinBuilder.append(Configuration.instance.randomGenerator.nextInt(10));
        }
        String superPin = superPinBuilder.toString();

        // Give the pins to the employee
        employee.rememberPin(pin);
        employee.rememberSuperPin(superPin);

        // Create magnetStripe
        String magnetStripeContent = employee.getId() + ";" +
                employee.getName() + ";" +
                employee.getClass().getSimpleName() + ";" +
                pin + ";" +
                superPin;
        MagnetStripe magnetStripe = new MagnetStripe(magnetStripeContent);

        return new IDCard(magnetStripe);
    }

    //TODO Test the encryption and decryption stuff.

    //TODO Test the States.

    public boolean checkInput(String input){
        return state.checkInput(this, input);
    }

    public boolean shouldBeAccepted(){
        return state.shouldBeAccepted();
    }


    public MagnetStripe getMagnetStripe() {
        return magnetStripe;
    }

    public void setState(IIDCardState state) {
        this.state = state;
    }
}
