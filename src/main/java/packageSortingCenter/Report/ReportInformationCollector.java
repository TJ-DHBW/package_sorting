package packageSortingCenter.Report;

import container.Package;
import java.util.ArrayList;

public class ReportInformationCollector {
    private static final ReportInformationCollector instance = new ReportInformationCollector();
    private int numberOfHandledLkw;
    private int normalPackageCounter;
    private int expressPackageCounter;
    private int valuePackageCounter;
    private ArrayList<Package> explosivePackages;

    public ReportInformationCollector() {
        numberOfHandledLkw = 0;
        normalPackageCounter = 0;
        expressPackageCounter = 0;
        valuePackageCounter = 0;
        explosivePackages = new ArrayList<>();
    }

    public static ReportInformationCollector getInstance() {
        return instance;
    }


    public int getNormalPackageCounter() {
        return normalPackageCounter;
    }

    public void setNormalPackageCounter(int normalPackageCounter) {
        this.normalPackageCounter = normalPackageCounter;
    }

    public int getExpressPackageCounter() {
        return expressPackageCounter;
    }

    public void setExpressPackageCounter(int expressPackageCounter) {
        this.expressPackageCounter = expressPackageCounter;
    }

    public int getValuePackageCounter() {
        return valuePackageCounter;
    }

    public void setValuePackageCounter(int valuePackageCounter) {
        this.valuePackageCounter = valuePackageCounter;
    }

    public ArrayList<Package> getExplosivePackages() {
        return explosivePackages;
    }

    public void setExplosivePackages(ArrayList<Package> explosivePackages) {
        this.explosivePackages = explosivePackages;
    }

    public int getNumberOfHandledLkw() {
        return numberOfHandledLkw;
    }

    public void setNumberOfHandledLkw(int numberOfHandledLkw) {
        this.numberOfHandledLkw = numberOfHandledLkw;
    }
}
