package object;

import function.LotteryHouseService;

/**
 * Created by jzl on 16/4/20.
 */
public class LotteryHouse implements Visualizable, Servable{
    private LotteryHouseService lotteryHouseService;

    public LotteryHouse() {
        lotteryHouseService = new LotteryHouseService();
    }

    @Override
    public void serve(Player[] players, int currentPlayer) {
        this.lotteryHouseService.serve(players, currentPlayer);
    }

    @Override
    public char toTexture() {
        return '彩';
    }
}
