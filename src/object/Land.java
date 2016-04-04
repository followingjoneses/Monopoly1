package object;

/**
 * Created by jzl on 16/4/2.
 */
public class Land {
    private static final int MAX_LEVEL = 6;

    private int level, price;
    private String owner;

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

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
