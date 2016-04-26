package object;

import function.LandService;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/2.
 */
public class Land extends Serving implements Visualizable {
    public static final int MAX_LEVEL = 6;

    private int level, price;
    private int owner = -1;
    private LandService landService;

    public Land(String name) {
        this.name = name;
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
    public void serve(ArrayList<Player> players, int currentPlayer) {
        this.landService.serve(players, currentPlayer, this);
    }

    @Override
    public void printCellInfo(ArrayList<Player> players) {
        System.out.println(this.name);

        String landOwner = (owner == -1) ? "无主" : "主人是"+ players.get(owner).getName();

        System.out.println(landOwner);
        System.out.println(level + "级");

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
