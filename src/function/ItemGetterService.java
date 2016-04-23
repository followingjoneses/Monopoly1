package function;

import object.Player;

/**
 * Created by jzl on 16/4/23.
 */
public class ItemGetterService {
    public void serve(Player[] players, int currentPlayer) {
        Player player = players[currentPlayer];

        int index = (int)(Math.random()*5);
        player.addItem(index, 1);
    }
}
