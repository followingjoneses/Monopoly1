package object;

import function.NewsCentreService;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/19.
 */
public class NewsCentre implements Visualizable, Servable {
    private NewsCentreService newsCentreService;

    public NewsCentre() {
        newsCentreService = new NewsCentreService();
    }

    @Override
    public void serve(ArrayList<Player> players, int currentPlayer) {
        this.newsCentreService.serve(players, currentPlayer);
    }

    @Override
    public char toTexture() {
        return '新';
    }
}
