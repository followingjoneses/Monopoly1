package function;

import game.*;

/**
 * Created by jzl on 16/4/2.
 */
public class Item {

    public void turnAround() {
        boolean[] playersNearby = findPlayers(5, true);

    }

    private boolean[] findPlayers(int step, boolean includeSelf) {
        boolean[] playersNearby = new boolean[Game.players.length];
        int location = Game.players[Game.currentPlayer].getLocation();

        for (int i=0;i<playersNearby.length && i!=Game.currentPlayer;i++) {
            int delta = Math.abs(Game.players[i].getLocation() - location + 68) % 68;
            if (delta <= step || delta>=(Map.mapLength-step))
                playersNearby[i] = true;
        }

        if (includeSelf)
            playersNearby[Game.currentPlayer] = true;

        return playersNearby;
    }

}
