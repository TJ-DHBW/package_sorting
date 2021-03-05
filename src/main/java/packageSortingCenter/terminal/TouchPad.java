package packageSortingCenter.terminal;

import packageSortingCenter.sortingFacility.SearchAlgorithm;
import packageSortingCenter.sortingFacility.SortingFacilityProxy;

public class TouchPad {
    private SortingFacilityProxy currentProxy;

    public void pressInitButton(){
        if(currentProxy == null){
            System.out.println("Please authenticate yourself first.");
        }else{
            currentProxy.init();
        }
    }

    public void pressNextButton(){
        if(currentProxy == null){
            System.out.println("Please authenticate yourself first.");
        }else{
            currentProxy.next();
        }
    }

    public void pressShutdownButton(){
        if(currentProxy == null){
            System.out.println("Please authenticate yourself first.");
        }else{
            currentProxy.shutdown();
        }
    }

    public void pressLockButton(){
        if(currentProxy == null){
            System.out.println("Please authenticate yourself first.");
        }else{
            currentProxy.lock();
        }
    }

    public void pressUnlockButton(){
        if(currentProxy == null){
            System.out.println("Please authenticate yourself first.");
        }else{
            currentProxy.unlock();
        }
    }

    public void pressStatisticsButton(){
        if(currentProxy == null){
            System.out.println("Please authenticate yourself first.");
        }else{
            currentProxy.showStatistics();
        }
    }

    public void pressSearchAlgorithmToBMButton(){
        if(currentProxy == null){
            System.out.println("Please authenticate yourself first.");
        }else{
            currentProxy.changeSearchAlgorithm(SearchAlgorithm.BM);
        }
    }

    public void pressSearchAlgorithmToKMPButton(){
        if(currentProxy == null){
            System.out.println("Please authenticate yourself first.");
        }else{
            currentProxy.changeSearchAlgorithm(SearchAlgorithm.RK);
        }
    }

    public void setCurrentProxy(SortingFacilityProxy currentProxy) {
        this.currentProxy = currentProxy;
    }
}
