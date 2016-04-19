package object;

/**
 * Created by jzl on 16/4/2.
 */
public class Land implements Visualizable{
    private static final int MAX_LEVEL = 6;

    private int level, price;
    private int owner;

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

    @Override
    public String toTexture() {
        switch (this.owner) {
            case 0:
                return "◎";
            case 1:
                return "○";
            case 2:
                return "●";
            case 3:
                return "③";
            case 4:
                return "④";
            default:
                return null;
        }
    }
}
