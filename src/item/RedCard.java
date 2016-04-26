package item;

import object.Player;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/25.
 */
public class RedCard extends Item {
    public RedCard() {
        this.itemIndex = 5;
        this.name = "红卡";
    }

    @Override
    public void use(ArrayList<Player> players, int currentPlayer){}
}
