package object;

import function.LandService;

/**
 * Created by jzl on 16/4/2.
 */
public class Land implements Visualizable, Servable{
    public static final int MAX_LEVEL = 6;

    private int level, price;
    private int owner = -1;
    private String name;
    private LandService landService;

    public Land() {
        this.level = 1;
        this.landService = new LandService();
        this.price = 500;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void upgrade() {
        this.level++;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOwner() {
        return this.owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void serve(Player[] players, int currentPlayer) {
        this.landService.serve(players, currentPlayer, this);
    }

    @Override
    public char toTexture() {
        switch (this.owner) {
            case -1:
                return '◎';
            case 0:
                return '○';
            case 1:
                return '●';
            case 2:
                return '③';
            case 3:
                return '④';
            default:
                return 0;
        }
    }
}
