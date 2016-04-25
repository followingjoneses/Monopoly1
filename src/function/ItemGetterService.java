package function;

import object.Player;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/23.
 */
public class ItemGetterService {
    private static final String WELCOME = "欢迎来到赠卡点\n";

    public void serve(ArrayList<Player> players, int currentPlayer) {
        System.out.print(WELCOME);

        Player player = players.get(currentPlayer);

        int index = (int)(Math.random()*5);
        player.addItem(index, 1);
    }
}
