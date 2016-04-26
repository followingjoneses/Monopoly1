package item;

import game.Map;
import object.Player;
import object.Stock;

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
    public void use(Stock[] stocks, Map map, ArrayList<Player> players, int currentPlayer){}
}
