package item;

import object.Player;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/25.
 */
public abstract class Item {
    protected int itemIndex;
    protected String name;

    public void use(ArrayList<Player> players, int currentPlayer){}

    public int getItemIndex() {
        return this.itemIndex;
    }

    public String getName() {
        return this.name;
    }
}
