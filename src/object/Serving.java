package object;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/23.
 */
public abstract class Serving {
    protected String name;

    public void serve(ArrayList<Player> players, int currentPlayer){}

    public void printCellInfo(ArrayList<Player> players){}
}
