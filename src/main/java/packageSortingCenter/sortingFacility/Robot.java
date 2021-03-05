package packageSortingCenter.sortingFacility;

import com.google.common.eventbus.Subscribe;
import container.Box;
import container.Pallet;
import container.Package;
import packageSortingCenter.centralControlUnit.events.general.ActivateRobotEvent;

import javax.annotation.Nonnull;

public class Robot {
    private SortingFacility sortingFacility;

    public Robot(SortingFacility sortingFacility) {
        this.sortingFacility = sortingFacility;
    }


    private void emptyIntermediateStorage(){
        for(Pallet[] storagePosition : sortingFacility.getPackageSortingCenter().getPalletIntermediateStorage().getStoredPallets()){
            for(int i = 0; i < storagePosition.length; i++){
                Pallet nextPallet = storagePosition[i];
                storagePosition[i] = null;
                emptyPallet(nextPallet);
            }
        }
    }

    private void emptyPallet(@Nonnull Pallet pallet){
        for(Box[] palletPosition : pallet.getBoxes()){
            for(int i = 0; i < palletPosition.length; i++){
                Box nextBox = palletPosition[i];
                palletPosition[i] = null;
                emptyBox(nextBox);
            }
        }

        sortingFacility.getPalletStoragePlace().store(pallet);
    }

    private void emptyBox(@Nonnull Box box){
        for(Package[][] packageLayer : box.getPackages()){
            for(Package[] packageSide : packageLayer){
                for(int i = 0; i < packageSide.length; i++){
                    Package nextPackage = packageSide[i];
                    packageSide[i] = null;
                    storePackage(nextPackage);
                }
            }
        }

        sortingFacility.getBoxStoragePlace().store(box);
    }

    private void storePackage(@Nonnull Package packageToStore){
        for(StorageLane lane : sortingFacility.getStorageLanes()){
            if(lane.put(packageToStore)){
                return;
            }
        }
        throw new IllegalStateException("All lanes were full. Robot was not able to store its package.");
    }

    @Subscribe
    public void receive(ActivateRobotEvent event){
        emptyIntermediateStorage();
    }
}
