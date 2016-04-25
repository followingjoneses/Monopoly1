package object;

import function.LotteryHouseService;

import java.util.ArrayList;

/**
 * Created by jzl on 16/4/20.
 */
public class LotteryHouse implements Visualizable, Servable{
    private LotteryHouseService lotteryHouseService;

    public LotteryHouse() {
        lotteryHouseService = new LotteryHouseService();
    }

    @Override
    public void serve(ArrayList<Player> players, int currentPlayer) {
        this.lotteryHouseService.serve(players, currentPlayer);
    }

    @Override
    public char toTexture() {
        return '彩';
    }
}
