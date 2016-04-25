package function;

import object.Player;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/23.
 */
public class ItemGetterService {
    public void serve(ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);

        int index = (int)(Math.random()*5);
        player.addItem(index, 1);
    }
}
