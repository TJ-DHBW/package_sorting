package container.generator;

import base.Configuration;
import container.Box;
import container.Package;
import container.Pallet;
import container.lkw.LKW;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvWriter {

    public void printGeneratedPackages(ArrayList<Package> packages) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.instance.exportDirectory + "base_package.csv"));
        for (int i = 0; i < packages.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int height = 0; height < 10; height++) {
                for (int width = 0; width < 10; width++) {
                    for (int length = 0; length < 25; length++) {
                        stringBuilder.append(packages.get(i).getContent()[length][width][height]);
                    }
                }
            }
            writer.write(packages.get(i).getId() + "," + stringBuilder.toString() + "," + packages.get(i).getZipCode() + "," + packages.get(i).getType().toString() + "," + packages.get(i).getWeight() + "\n");
        }
        writer.close();
    }
    public void printGeneratedBoxes(ArrayList<Box> boxes) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.instance.exportDirectory + "base_box.csv"));
        for (int boxCounter = 0; boxCounter < boxes.size(); boxCounter++) {
            writer.write(boxes.get(boxCounter).getId());
            for(int level = 0; level<5; level++){
                for(int side = 0; side<2; side++){
                    for(int width = 0; width<4; width++){
                        if(!(boxes.get(boxCounter).getaPackages()[level][side][width] == null)) {
                            writer.write(","+boxes.get(boxCounter).getaPackages()[level][side][width].getId());
                        }
                    }
                }
            }
            writer.write("\n");
        }
        writer.close();
    }
    public void printGeneratedPallets(ArrayList<Pallet> pallets) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.instance.exportDirectory + "base_pallet.csv"));
        for (int palletCounter = 0; palletCounter < pallets.size(); palletCounter++) {
            for(int position = 0; position<4; position++){
                for(int stackNumber = 0; stackNumber<3; stackNumber++){
                    if(pallets.get(palletCounter).getBoxes()[position][stackNumber]!= null) {
                        writer.write(pallets.get(palletCounter).getId() + ","
                                + position + ","
                                + stackNumber + ","
                                + pallets.get(palletCounter).getBoxes()[position][stackNumber].getId()
                                + "\n");
                    }
                }
            }
        }
        writer.close();
    }
    public void printGeneratedLKWs(ArrayList<LKW> lkws) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(Configuration.instance.exportDirectory + "base_lkw.csv"));
        for (int lkwCounter = 0; lkwCounter < lkws.size(); lkwCounter++) {
            for (int palletSideCounter = 0; palletSideCounter<2; palletSideCounter++){
                for(int palletLengthCounter = 0; palletLengthCounter<5; palletLengthCounter++) {
                writer.write(lkws.get(lkwCounter).getId());
                if(palletSideCounter == 0){
                    writer.write(",left");
                }
                else {
                    writer.write(",right");
                }
                    writer.write(","+palletLengthCounter);
                    writer.write(","+lkws.get(lkwCounter).getTrailer().getPallets()[palletSideCounter][palletLengthCounter].getId());
                    writer.write("\n");
                }
            }
        }
        writer.close();
    }
}
