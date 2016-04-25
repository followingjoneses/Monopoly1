package item;

import object.Player;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/25.
 */
public abstract class Item {
    protected int itemIndex;

    public void use(ArrayList<Player> players, int currentPlayer){}
}
