package function;

import object.Player;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jzl on 16/4/20.
 */
public class ItemShopService {
    private static final String WELCOME = "欢迎来到道具店\n",
        HINT = "玩家%s当前拥有点券%d,每样道具售价50点券\n",
        AVAILABLE = "可以购买的道具有:\n0 转向卡\t1 遥控骰子\t2 路障\t3 均富卡\t4 查税卡\n",
        SELECTION = "请输入你要购买的道具编号,按q退出:\n",
        WARNING = "请输入符合要求的字符\n";
    private static final int PRICE = 50;

    public void serve(ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);

        System.out.print(WELCOME);

        while (true) {
            System.out.printf(HINT, player.getName(), player.getPoint());
            System.out.print(AVAILABLE + SELECTION);
            Scanner sc = new Scanner(System.in);
            String option = sc.next();

            if (option.equals("q"))
                break;

            try {
                int index = Integer.parseInt(option);

                if (index >= 0 && index <= 4)
                    sell(player, index);
                else
                    System.out.print(WARNING);
            } catch (NumberFormatException e) {
                System.out.print(WARNING);
            }
        }
    }

    private void sell(Player player, int index) {
        if (player.getPoint() < PRICE)
            System.out.println("点券不足");
        else {
            player.addItem(index, 1);
            player.addPoint(-PRICE);
        }
    }
}
