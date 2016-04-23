package object;

import function.OpeningService;

/**
 * Created by jzl on 16/4/20.
 */
public class Opening implements Visualizable, Servable{
    private OpeningService openingService;

    public Opening() {
        this.openingService = new OpeningService();
    }

    @Override
    public void serve(Player[] players, int currentPlayer) {
        this.openingService.serve(players, currentPlayer);
    }

    @Override
    public char toTexture() {
        return '空';
    }
}
