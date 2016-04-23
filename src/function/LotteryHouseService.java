package function;

import object.Player;
import java.util.Random;

/**
 * Created by jzl on 16/4/20.
 */
public class LotteryHouseService {
    private static final String WIN = "恭喜,你中了%d元!\n",
        NOTWIN = "很遗憾,你没有中奖\n";

    public void serve(Player[] players, int currentPlayer) {
        Random random = new Random();
        boolean win = random.nextBoolean();
        Player player = players[currentPlayer];

        if (win) {
            int money = (int)(Math.random()*10000);
            System.out.printf(WIN, money);
            player.addCash(money);
        } else
            System.out.print(NOTWIN);
    }
}
