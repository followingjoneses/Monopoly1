package game;

import object.Player;
import java.util.*;
import java.text.*;

/**
 * Created by jzl on 16/4/21.
 */
public class Menu {
    private static final String CURRENT_PLAYER = "现在是玩家%s的操作时间,你的前进方向是%s\n",
        OPTION = "你现在可以进行如下操作:\n"+
                "0 - 查看地图\n"+
                "1 - 查看原始地图\n"+
                "2 - 使用道具\n"+
                "3 - 前方10步内示警\n"+
                "4 - 查看前后指定步数的具体信息\n"+
                "5 - 查看玩家的资产信息\n"+
                "6 - 扔骰子\n"+
                "7 - 认输\n"+
                "请选择:\n";

    public Menu() {

    }

    public void printMenu(Calendar calendar, Player player) {
        String date = (new SimpleDateFormat("yyyy年M月d日")).format(calendar.getTime());
        System.out.println("今天是"+date);

        String direction = player.isClockWise() ? "顺时针" : "逆时针";
        System.out.printf(CURRENT_PLAYER, player.getName(), direction);
        System.out.print(OPTION);
    }
}
