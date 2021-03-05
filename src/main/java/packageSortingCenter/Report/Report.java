package packageSortingCenter.Report;

import container.Package;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Report {
    private final Date date;
    private final int numberOfHandledLKW;
    private final int scannedPackagesNormal;
    private final int scannedPackagesExpress;
    private final int scannedPackagesValue;
    private final ArrayList<Package> packagesWithExplosives;

    private Report(Builder builder){
        date = builder.date;
        numberOfHandledLKW = builder.numberOfHandledLKW;
        scannedPackagesNormal = builder.scannedPackagesNormal;
        scannedPackagesValue = builder.scannedPackagesValue;
        scannedPackagesExpress = builder.scannedPackagesExpress;
        packagesWithExplosives = builder.packagesWithExplosives;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        stringBuilder.append("Date and Time: ").append(dateFormat.format(date)).append("\n");
        stringBuilder.append("Number of normal packages scanned: ").append(scannedPackagesNormal).append("\n");
        stringBuilder.append("Number of express packages scanned: ").append(scannedPackagesExpress).append("\n");
        stringBuilder.append("Number of value packages scanned: ").append(scannedPackagesValue).append("\n");
        stringBuilder.append("Ids of Packages with exp!os:ves: ");
        for(Package packageWithExplosives : packagesWithExplosives){
            stringBuilder.append(packageWithExplosives.getId()).append(",");
        }
        return stringBuilder.toString();
    }

    public static class Builder{
        private Date date;
        private int numberOfHandledLKW;
        private int scannedPackagesNormal;
        private int scannedPackagesExpress;
        private int scannedPackagesValue;
        private ArrayList<Package> packagesWithExplosives;

        public Builder date(Date date){
            this.date = date;
            return this;
        }

        public Builder numberOfHandledLKW(int number){
            this.numberOfHandledLKW = number;
            return this;
        }

        public Builder scannedPackagesNormal(int scannedPackagesNormal){
            this.scannedPackagesNormal = scannedPackagesNormal;
            return this;
        }

        public Builder scannedPackagesExpress (int scannedPackagesExpress){
            this.scannedPackagesExpress = scannedPackagesExpress;
            return this;
        }

        public Builder scannedPackagesValue(int scannedPackagesValue){
            this.scannedPackagesValue = scannedPackagesValue;
            return this;
        }

        public Builder packagesWithExplosives(ArrayList<Package> packagesWithExplosives){
            this.packagesWithExplosives = packagesWithExplosives;
            return this;
        }

        public Report build(){
            return new Report(this);
        }
    }
}
