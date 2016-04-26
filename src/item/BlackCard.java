package item;

import game.Map;
import object.Player;
import object.Stock;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/25.
 */
public class BlackCard extends Item {
    public BlackCard() {
        this.itemIndex = 6;
        this.name = "黑卡";
    }

    @Override
    public void use(Stock[] stocks, Map map, ArrayList<Player> players, int currentPlayer){}
}
