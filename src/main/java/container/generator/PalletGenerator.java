package container.generator;

import base.Configuration;
import container.Box;
import container.Pallet;

import java.util.ArrayList;

public class PalletGenerator {
    int currentIDGiven = 1;
    ArrayList<Pallet> pallets;
    //PalletGenerator only generates Pallets -> single responsibility principle
    public PalletGenerator() {
        pallets = new ArrayList<>();
    }

    public ArrayList<Pallet> palletGeneration(ArrayList<Box> boxes) {
        int boxCounter = 0;
        for (int i = 0; i < Configuration.instance.numberOfPallets; i++) {
            Pallet pallet = new Pallet();
            pallet.setId(currentIDGiven);
            currentIDGiven++;
            for (int position = 0; position < 4; position++) {
                for (int stackNumber = 0; stackNumber < 3; stackNumber++) {
                    if (boxes.get(boxCounter) != null) {
                        pallet.getBoxes()[position][stackNumber] = boxes.get(boxCounter);
                        boxCounter++;
                    }
                }
            }
            pallets.add(pallet);
        }
        return pallets;
    }
}
