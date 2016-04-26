package item;

import object.Player;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/25.
 */
public class Barrier extends Item {
    public Barrier() {
        this.itemIndex = 2;
        this.name = "路障";
    }

    @Override
    public void use(ArrayList<Player> players, int currentPlayer){

    }
}
