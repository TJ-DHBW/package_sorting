package container.generator;

import container.Box;
import container.Pallet;
import container.lkw.LKW;
import container.Package;

import java.io.IOException;
import java.util.ArrayList;

public class GeneratorCSVFiles {

    public static void main(String[] args) throws IOException {
        Integer[] packageIndexToHide = {3,57,100,200};
        PackageGenerator packageGenerator = new PackageGenerator();
        BoxGenerator boxGenerator = new BoxGenerator();
        PalletGenerator palletGenerator = new PalletGenerator();
        LKWGenerator lkwGenerator = new LKWGenerator();
        ArrayList<Package> packages = packageGenerator.packageGeneration();

        for(int i = 0; i<packageIndexToHide.length; i++){
            char[][][] content = packageGenerator.hideExplosive(packages.get(packageIndexToHide[i]).getContent());
            packages.get(packageIndexToHide[i]).setContent(content);
        }

        ArrayList<Box> boxes = boxGenerator.boxGeneration(packages);
        ArrayList<Pallet> pallets = palletGenerator.palletGeneration(boxes);
        ArrayList<LKW> lkws = lkwGenerator.lkwGeneration(pallets);
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.printGeneratedPackages(packages);
        csvWriter.printGeneratedBoxes(boxes);
        csvWriter.printGeneratedPallets(pallets);
        csvWriter.printGeneratedLKWs(lkws);
    }
}
