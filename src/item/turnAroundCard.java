package item;

import object.Player;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/25.
 */
public class turnAroundCard extends Item {
    public turnAroundCard() {
        this.itemIndex = 0;
        this.name = "转向卡";
    }

    @Override
    public void use(ArrayList<Player> players, int currentPlayer){

    }
}
