package game;

import object.*;

import java.io.*;
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
                "请选择:\n",
        WARNING = "请输入符合要求的字符\n",
        ITEM = "你现在拥有的道具如下:\n",
        CARD_NUMBER = "请输入想使用的卡片编号,按x返回上一层:\n",
        CHECK_CELL_INFO = "请输入具体步数(顺时针为正,逆时针为负):\n",
        PLAYERS_INFO = "昵称\t现金\t存款\t房产\t\n",
        DICE = "你掷出了%d\n",
        GIVE_UP = "玩家%s认输了!\n";

    public Menu() {

    }

    int printMainMenu(Map map, Calendar calendar, ArrayList<Player> players, int currentPlayer) {
        String date = (new SimpleDateFormat("yyyy年M月d日")).format(calendar.getTime());
        System.out.println("今天是"+date);

        Player player = players.get(currentPlayer);

        String direction = player.isClockWise() ? "顺时针" : "逆时针";
        System.out.printf(CURRENT_PLAYER, player.getName(), direction);
        System.out.print(OPTION);

        int option = -1;
        Scanner sc = new Scanner(System.in);
        try {
            option = sc.nextInt();
            if (option >= 0 && option <=7) {
                printSubmenu(map, option, players, currentPlayer);
            } else
                System.out.print(WARNING);
        } catch (InputMismatchException e) {
            System.out.print(WARNING);
        }

        return option;
    }

    private void printSubmenu(Map map, int option, ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);

        switch (option) {
            case 0:
                map.printCurMap(currentPlayer);
                break;
            case 1:
                map.printInitialMap();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                checkCellInfo(map, players, currentPlayer);
                break;
            case 5:
                printPlayerProperties(players);
                break;
            case 6:
                rollDice(map, players, currentPlayer);
                break;
            case 7:
                giveUp(players, currentPlayer);
                break;
        }
    }

    private void printUseItem(Player player) {
        System.out.print(ITEM);
    }

    private void checkCellInfo(Map map, ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);

        System.out.print(CHECK_CELL_INFO);
        try {
            Scanner sc = new Scanner(System.in);
            int step = sc.nextInt();
            if (step >= -10 && step <= 10) {
                int location = (player.getLocation() + step + Map.MAP_LENGTH) % Map.MAP_LENGTH;
                Cell cell = map.getCell(Map.COORDINATE[location][0], Map.COORDINATE[location][1]);
                cell.getServing().printCellInfo(players);
            } else
                System.out.print(WARNING);
        } catch (InputMismatchException e) {
            System.out.print(WARNING);
        }
    }

    private void printPlayerProperties(ArrayList<Player> players) {
        System.out.print(PLAYERS_INFO);
        for (int i=0;i<players.size();i++)
            System.out.println(players.get(i).getName() + "\t" + players.get(i).getCash() + "\t" +
                players.get(i).getDeposit() + "\t" + players.get(i).getHouseProperty());
    }

    private void rollDice(Map map, ArrayList<Player> players, int currentPlayer) {
        Player player = players.get(currentPlayer);
        int dice = (int)(Math.random()*6) + 1;
        System.out.printf(DICE, dice);
        map.getCell(Map.COORDINATE[player.getLocation()][0], Map.COORDINATE[player.getLocation()][1]).dismissView(player);
        player.addLocation(dice);

        Cell curCell = map.getCell(Map.COORDINATE[player.getLocation()][0], Map.COORDINATE[player.getLocation()][1]);

        curCell.addView(player);
        map.printCurMap(currentPlayer);

        curCell.getServing().serve(players, currentPlayer);
    }

    private void giveUp(ArrayList<Player> players, int currentPlayer) {
        System.out.printf(GIVE_UP, players.get(currentPlayer).getName());
        for (int i=0;i<players.size();i++) {
            if (i == currentPlayer)
                players.remove(players.get(i));
        }
    }
}
