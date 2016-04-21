package function;

import object.Player;
import java.util.Random;

/**
 * Created by jzl on 16/4/20.
 */
public class LotteryService {
    private static final String WIN = "恭喜,你中了%d元!\n",
        NOTWIN = "很遗憾,你没有中奖\n";

    public void serve(Player player) {
        Random random = new Random();
        boolean win = random.nextBoolean();

        if (win) {
            int money = (int)(Math.random()*10000);
            System.out.printf(WIN, money);
            player.addCash(money);
        } else
            System.out.print(NOTWIN);
    }
}
