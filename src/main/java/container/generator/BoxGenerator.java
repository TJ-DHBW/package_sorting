package container.generator;

import base.Configuration;
import container.Box;
import container.Package;

import java.util.ArrayList;
import java.util.HashSet;

public class BoxGenerator {
    private ArrayList<Box> boxes;
    public HashSet<String> allGeneratedIds = new HashSet<>();

    public BoxGenerator() {
        boxes = new ArrayList<>();
    }
    //BoxGenerator only generates Boxes -> single responsibility principle
    public ArrayList<Box> boxGeneration(ArrayList<Package> packages){
        int packageCounter = 0;
        do{
            Box box = new Box();
            for(int level = 0; level<5; level++){
                for(int side = 0; side<2; side++){
                    for(int width = 0; width<4; width++){
                        if(packageCounter < packages.size()) {
                            box.getPackages()[level][side][width] = packages.get(packageCounter);
                            packageCounter++;
                        }
                    }
                }
            }
            box.setId(idRandom());
            boxes.add(box);
        }while (packageCounter < packages.size());
        return boxes;
    }

    public String idRandom(){
        String id;
        do{
            StringBuilder stringBuilder = new StringBuilder();
            for(int idLength = 0; idLength<5; idLength++){
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
}
