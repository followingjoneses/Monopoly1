package game;

import object.*;

/**
 * Created by jzl on 16/4/2.
 */
public class Game {
    public static Player[] players;
    public static int currentPlayer;

    public static void initial(int num) {
        players = new Player[num];
        for (int i=0;i<num;i++)
            players[i] = new Player();
    }

}
