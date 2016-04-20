package object;

import function.LotteryService;

/**
 * Created by jzl on 16/4/20.
 */
public class LotteryHouse implements Visualizable{
    private LotteryService lotteryService;

    public LotteryHouse() {
        lotteryService = new LotteryService();
    }

    public void serve(Player player) {
        this.lotteryService.serve(player);
    }

    @Override
    public String toTexture() {
        return "彩";
    }
}
