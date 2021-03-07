package container.generator;

import base.Configuration;
import container.Pallet;
import container.lkw.LKW;
import container.lkw.LKWTrailer;

import java.util.ArrayList;
import java.util.HashSet;

public class LKWGenerator {
    private HashSet<String> allGeneratedIds = new HashSet<>();

    public ArrayList<LKW> lkwGeneration(ArrayList<Pallet> pallets) {
        //LKWGenerator only generates LKWs -> single responsibility principle
        ArrayList<LKW> lkws = new ArrayList<>();
        int palletCounter = 0;
        for (int lkwCounter = 0; lkwCounter < Configuration.instance.numberOfLkw; lkwCounter++) {
            LKW lkw = new LKW();
            lkw.setId(idRandom());
            LKWTrailer lkwTrailer = new LKWTrailer();
            for (int palletSideCounter = 0; palletSideCounter < 2; palletSideCounter++) {
                for (int palletLengthCounter = 0; palletLengthCounter < 5; palletLengthCounter++) {
                    lkwTrailer.getPallets()[palletSideCounter][palletLengthCounter] = pallets.get(palletCounter);
                    palletCounter++;
                }
            }
            lkw.setTrailer(lkwTrailer);
            lkws.add(lkw);
        }
        return lkws;
    }

    public String idRandom() {
        String id;
        do {
            StringBuilder stringBuilder = new StringBuilder();
            for (int idLength = 0; idLength < 4; idLength++) {
                int randomChar = Configuration.instance.randomGenerator.nextInt(36);
                if (randomChar < 10) {
                    stringBuilder.append(randomChar);
                } else {
                    stringBuilder.append((char) (randomChar + 87));
                }
            }
            id = stringBuilder.toString();
        } while (allGeneratedIds.contains(id));
        allGeneratedIds.add(id);
        return id;
    }
}
