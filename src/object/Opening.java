package object;

import function.OpeningService;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/20.
 */
public class Opening implements Visualizable, Servable{
    private OpeningService openingService;

    public Opening() {
        this.openingService = new OpeningService();
    }

    @Override
    public void serve(ArrayList<Player> players, int currentPlayer) {
        this.openingService.serve();
    }

    @Override
    public char toTexture() {
        return '空';
    }
}
