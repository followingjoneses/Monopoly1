package object;

import function.PointGetterService;

/**
 * Created by jzl on 16/4/20.
 */
public class PointGetter implements Visualizable, Servable {
    private PointGetterService pointGetterService;

    public PointGetter() {
        this.pointGetterService = new PointGetterService();
    }

    @Override
    public void serve(Player[] players, int currentPlayer) {
        this.pointGetterService.serve(players, currentPlayer);
    }

    @Override
    public char toTexture() {
        return '券';
    }
}
