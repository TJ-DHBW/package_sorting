package packageSortingCenter.sortingFacility;

import java.util.ArrayList;

public class StoragePlace<T> {
    private final ArrayList<T> storage;

    public StoragePlace() {
        this.storage = new ArrayList<>();
    }

    public void store(T objectToStore){
        storage.add(objectToStore);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for(T obj : storage){
            builder.append(obj).append(';');
        }

        return builder.toString();
    }
}
