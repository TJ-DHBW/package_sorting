package container;

public class Pallet {
    /**
     * Starting from 1
     */
    private int id;
    /**
     * <ul><li>There are 4 Positions on each Pallet.</li><li>Each Position can hold 3 Boxes.</li></ul>
     */
    private Box[][] boxes;

    public Pallet() {
        boxes = new Box[4][3];
    }

    //region Getter and Setter
    public int getId() {
        return id;
    }

    public Box[][] getBoxes() {
        return boxes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBoxes(Box[][] boxes) {
        this.boxes = boxes;
    }

    //endregion


}
