package base;

import container.Box;
import container.Package;
import container.Pallet;
import container.generator.BoxGenerator;
import container.generator.CsvWriter;
import container.generator.PackageGenerator;
import container.generator.PalletGenerator;

import java.io.IOException;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        PackageGenerator packageGenerator = new PackageGenerator();
        BoxGenerator boxGenerator = new BoxGenerator();
        PalletGenerator palletGenerator = new PalletGenerator();
        ArrayList<Package> packages = packageGenerator.packageGeneration();
        ArrayList<Box> boxes = boxGenerator.boxGeneration(packages);
        ArrayList<Pallet> pallets = palletGenerator.palletGeneration(boxes);
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.printGeneratedPackages(packages);
        csvWriter.printGeneratedBoxes(boxes);
        csvWriter.printGeneratedPallets(pallets);
    }
}
