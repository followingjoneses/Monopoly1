package object;

/**
 * Created by jzl on 16/4/2.
 */
public class Player implements Visualizable{
    private int cash, deposit, houseProperty, point, location;
    private boolean isClockWise;
    private String name;
    private int[] items;

    public Player() {
        items = new int[7];
    }

    public int getCash() {
        return this.cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getDeposit() {
        return this.deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getHouseProperty() {
        return this.houseProperty;
    }

    public void setHouseProperty(int houseProperty) {
        this.houseProperty = houseProperty;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getLocation() {
        return this.location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public boolean isClockWise() {
        return this.isClockWise;
    }

    public void setClockWise(boolean isClockWise) {
        this.isClockWise = isClockWise;
    }

    public void changeDirection() {
        this.isClockWise = !this.isClockWise;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getItems() {
        return this.items;
    }

    public void setItems(int[] items) {
        this.items = items;
    }

    public int getItem(int index) {
        return items[index];
    }

    public void setItem(int index, int number) {
        items[index] = number;
    }

    @Override
    public String toTexture() {
        return null;
    }
}
