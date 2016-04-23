package object;

import game.Map;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/2.
 */
public class Player implements Visualizable{
    private int cash, deposit, houseProperty, point, location, number;
    private boolean isClockWise;
    private String name;
    private int[] items;
    private ArrayList<Land> lands;

    public Player(int number) {
        items = new int[7];
        lands = new ArrayList<Land>();
        this.number = number;
        isClockWise = true;
    }

    public int getCash() {
        return this.cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void addCash(int cash) {
        this.cash += cash;
    }

    public int getDeposit() {
        return this.deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public void addDeposit(int deposit) {
        this.deposit += deposit;
    }

    public int getHouseProperty() {
        return this.houseProperty;
    }

    public void setHouseProperty(int houseProperty) {
        this.houseProperty = houseProperty;
    }

    public void addHouseProperty(int houseProperty) {
        this.houseProperty += houseProperty;
    }

    public int getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void addPoint(int point) {
        this.point += point;
    }

    public int getLocation() {
        return this.location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public void addLocation(int dice) {
        if (isClockWise)
            location = (location + dice) % Map.MAP_LENGTH;
        else
            location = (location - dice + Map.MAP_LENGTH) % Map.MAP_LENGTH;
    }

    public int getNumber() {
        return this.number;
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

    public void addItem(int index, int number) {
        items[index] += number;
    }

    public void addLand(Land land) {
        lands.add(land);
    }

    public ArrayList<Land> getLands() {
        return this.lands;
    }

    @Override
    public char toTexture() {
        switch (number) {
            case 0:
                return '□';
            case 1:
                return '■';
            case 2:
                return '△';
            case 3:
                return '☆';
        }
        return 0;
    }
}
