package container.generator;

import base.Configuration;
import container.Package;
import container.PackageType;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;

public class PackageGenerator {
    private final Character[] charPoolWithoutLetters = {'.', ':', '!', '-'};
    private ArrayList<Package> packages = new ArrayList<>();
    private HashSet<String> allGeneratedIds = new HashSet<>();
    private String explosive = "exp!os:ve";

    public PackageGenerator() {
    }

    public ArrayList<Package> packageGeneration(){
        for (int packageNumber = 0; packageNumber < Configuration.instance.numberOfPackages; packageNumber++){
            Package packageGenerated = new Package();
            packageGenerated.setId(idRandom());
            packageGenerated.setWeight(weightRandom());
            packageGenerated.setZipCode(zipCodeRandom());
            packageGenerated.setContent(contentRandom());
            if(packageNumber<Configuration.instance.numberOfPackages*0.8){
                packageGenerated.setType(PackageType.NORMAL);
            }
            else if (packageNumber<Configuration.instance.numberOfPackages*0.95){
                packageGenerated.setType(PackageType.EXPRESS);
            }
            else{
                packageGenerated.setType(PackageType.VALUE);
            }
            packages.add(packageGenerated);
        }
        Collections.shuffle(packages);
        return packages;
    }

    public String idRandom(){
        String id;
        do{
            StringBuilder stringBuilder = new StringBuilder();
            for(int idLength = 0; idLength<6; idLength++){
                int randomChar = Configuration.instance.randomGenerator.nextInt(36);
                if(randomChar <10){
                    stringBuilder.append(randomChar);
                }
                else{
                    stringBuilder.append((char) (randomChar+87));
                }
            }
            id = stringBuilder.toString();
        }while (allGeneratedIds.contains(id));
        allGeneratedIds.add(id);
        return id;
    }

    public char[][][] contentRandom(){
        char[][][] content = new char[25][10][10];
        for(int height = 0; height<10; height++){
            for(int width = 0; width<10; width++){
                StringBuilder checkForExplosives = new StringBuilder();
                for (int length = 0; length<25; length++){
                    int characterNumber = Configuration.instance.randomGenerator.nextInt(30);
                    if(characterNumber < 26){
                        checkForExplosives.append((char) (characterNumber+97));
                        content[length][width][height] = (char) (characterNumber+97);
                    }
                    else{
                        checkForExplosives.append(charPoolWithoutLetters[characterNumber-26]);
                        content[length][width][height] = charPoolWithoutLetters[characterNumber-26];
                    }
                }
                while(checkForExplosives.toString().contains(explosive)){
                    StringBuilder replacement = new StringBuilder();
                    for(int i = 0; i<explosive.length(); i++){
                        int characterNumber = Configuration.instance.randomGenerator.nextInt(30);
                        if(characterNumber < 26){
                             replacement.append((char) (characterNumber+97));
                        }
                        else{
                            replacement.append(charPoolWithoutLetters[characterNumber-26]);
                        }
                    }
                    checkForExplosives.toString().replace(explosive, replacement.toString());
                }
            }
        }
        return content;
    }

    public char[][][] hideExplosive(char[][][] content){
        int height = Configuration.instance.randomGenerator.nextInt(10-explosive.length()+1);
        int width = Configuration.instance.randomGenerator.nextInt(10);
        int length = Configuration.instance.randomGenerator.nextInt(25);
        for (int counter = 0; counter<explosive.length(); counter++){
            content[length][width][height+counter] = explosive.charAt(counter);
        }
        return content;
    }

    public Float weightRandom(){
        int base = Configuration.instance.randomGenerator.nextInt(4);
        Float weight = Configuration.instance.randomGenerator.nextFloat()+base+1;
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.UK);
        formatter.setMaximumFractionDigits(2);
        weight = Float.valueOf(formatter.format(weight));
        return weight;
    }

    public String zipCodeRandom(){
        StringBuilder zipCodeBuilder = new StringBuilder();
        zipCodeBuilder.append(Configuration.instance.randomGenerator.nextInt(10));
        zipCodeBuilder.append(Configuration.instance.randomGenerator.nextInt(9)+1);
        zipCodeBuilder.append(Configuration.instance.randomGenerator.nextInt(10));
        zipCodeBuilder.append(Configuration.instance.randomGenerator.nextInt(4)+6);
        zipCodeBuilder.append(Configuration.instance.randomGenerator.nextInt(2)+7);
        return zipCodeBuilder.toString();
    }
}
