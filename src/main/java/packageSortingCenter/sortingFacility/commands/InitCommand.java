package packageSortingCenter.sortingFacility.commands;

import base.Configuration;
import container.Box;
import container.Package;
import container.Pallet;
import container.lkw.LKW;
import container.lkw.LKWTrailer;
import packageSortingCenter.sortingFacility.SortingFacility;
import unordered.PacketType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class InitCommand implements ISortingFacilityCommand {
    private final SortingFacility sortingFacility;

    public InitCommand(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }

    @Override
    public void execute() {
        ArrayList<LKW> lkws = generateLkwFromCSV(generatePalletsFromCSV(generateBoxesFromCSV(generatePackagesFromCSV())));
        sortingFacility.getLkwWaitingArea().setLkws(lkws.toArray(new LKW[0]));
    }

    public HashMap<String, Package> generatePackagesFromCSV() {
        HashMap<String, Package> packages = new HashMap<>();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Configuration.instance.exportDirectory + "base_package.csv")));
            while ((line = bufferedReader.readLine()) != null) {
                String[] generalData = line.split(",");
                Package packageToGenerate = new Package();
                packageToGenerate.setId(generalData[0]);
                packageToGenerate.setContent(getContentAsChar(generalData[1]));
                packageToGenerate.setZipCode(generalData[2]);
                packageToGenerate.setType(PacketType.valueOf(generalData[3]));
                packageToGenerate.setWeight(Float.parseFloat(generalData[4]));
                packages.put(packageToGenerate.getId(), packageToGenerate);
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return packages;
    }

    public char[][][] getContentAsChar(String contentAsChar) {
        int charCounter = 0;
        char[][][] content = new char[10][10][25];
        for (int height = 0; height < 10; height++) {
            for (int width = 0; width < 10; width++) {
                for (int length = 0; length < 25; length++) {
                    content[height][width][length] = contentAsChar.charAt(charCounter);
                    charCounter++;
                }
            }
        }
        return content;
    }

    public HashMap<String, Box> generateBoxesFromCSV(HashMap<String, Package> packages) {
        HashMap<String, Box> generatedBoxes = new HashMap<>();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Configuration.instance.exportDirectory + "base_box.csv")));
            while ((line = bufferedReader.readLine()) != null) {
                String[] generalData = line.split(",");
                Box box = new Box();
                box.setId(generalData[0]);
                int generalDataCounter = 1;
                for (int level = 0; level < 5; level++) {
                    for (int side = 0; side < 2; side++) {
                        for (int width = 0; width < 4; width++) {
                            box.getPackages()[level][side][width] = packages.get(generalData[generalDataCounter]);
                            generalDataCounter++;
                        }
                    }
                }
                generatedBoxes.put(box.getId(), box);
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return generatedBoxes;
    }

    public HashMap<String, Pallet> generatePalletsFromCSV(HashMap<String, Box> boxes){
        HashMap<String, Pallet> pallets = new HashMap<>();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader
                    (Configuration.instance.exportDirectory + "base_pallet.csv"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] generalData = line.split(",");
                if(pallets.get(generalData[0]) == null){
                    Pallet pallet = new Pallet();
                    pallet.setId(Integer.parseInt(generalData[0]));
                    pallets.put(generalData[0], pallet);
                }
                pallets.get(generalData[0]).getBoxes()[Integer.parseInt(generalData[1])][Integer.parseInt(generalData[2])]
                        = boxes.get(generalData[3]);
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return  pallets;
    }
    public ArrayList<LKW> generateLkwFromCSV(HashMap<String, Pallet> pallets){
        HashMap<String, LKW> lkws = new HashMap<>();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader
                    (Configuration.instance.exportDirectory + "base_lkw.csv"));
            while ((line = bufferedReader.readLine()) != null) {
                String[] generalData = line.split(",");
                if(lkws.get(generalData[0]) == null){
                    LKW lkw = new LKW();
                    LKWTrailer trailer = new LKWTrailer();
                    lkw.setId(generalData[0]);
                    lkw.setTrailer(trailer);
                    lkws.put(lkw.getId(), lkw);
                }
                int side = generalData[1].equals("left")?0:1;
                lkws.get(generalData[0]).getTrailer().getPallets()[side][Integer.parseInt(generalData[2])]
                        = pallets.get(generalData[3]);
            }
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        ArrayList<LKW> lkwsAsArray = new ArrayList<>();
        for(String lkwId : lkws.keySet()){
            lkwsAsArray.add(lkws.get(lkwId));
        }
        return lkwsAsArray;
    }
}
