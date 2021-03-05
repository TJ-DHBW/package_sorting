package packageSortingCenter.sortingFacility;

import container.Box;

public class StorageLane {
    private final Box[] lane;

    private int nextFreeIndex;
    private int nextBoxIndex;

    public StorageLane(int size) {
        this.lane = new Box[size];

        this.nextFreeIndex = 0;
        this.nextBoxIndex = 0;
    }

    //TODO Implement the Observing sensor


    public boolean put(Box box){
        if(nextFreeIndex < lane.length){
            lane[nextFreeIndex] = box;
            nextFreeIndex++;
            return true;
        }

        return false;
    }

    public Box getNext(){
        if(!isEmpty()){
            Box tmp = lane[nextBoxIndex];
            lane[nextBoxIndex] = null;
            nextBoxIndex++;
            return tmp;
        }

        return null;
    }

    public boolean isEmpty(){
        return nextFreeIndex == 0 || nextBoxIndex == nextFreeIndex;
    }

    public boolean isFull(){
        return nextFreeIndex >= lane.length && nextBoxIndex == 0;
    }
}
